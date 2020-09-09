package img;
import java.io.*;
class SPIHT{

    int dim;//side of the image
float bpp;//keeps the target bitrate in bits per pixel
    int lungCod;//code length = bpp*dim*dim
float[] tab;//transformed image (the DWT coeffcients)
float[] LIP;//List of Insignificant Pixels
float[] LSP;//List of Significant Pixels
    List LIS;//List of insignificant sets
    int nrLIP, nrLSP;//number of elements in the LIP and LSP
float n;//current threshold
    DataOutputStream dos;//Stream the image code will be written to
    SPIHT(float[] tab, float bpp, int dim, DataOutputStream dos){
//
//constructor allocates memory and initializes the elds
        this.dos = dos;
//length of the code at the target bitrate
        lungCod = (int)(bpp*dim*dim);
        this.tab = tab; this.dim = dim; this.bpp = bpp;
        LIP = new float[dim*dim]; LSP = new float[dim*dim];
        LIS = new List();
        nrLIP = 0; nrLSP = 0;
    }//end of constructor
    boolean SD(int i, int j){
//
//verifies if the quadtrees with the roots in the direct
//descendents of coefficient(i,j) are zerotrees
        return (i<dim/2 && j<dim/2) && (genTree(2*i, 2*j) ||
                genTree(2*i, 2*j+1) || genTree(2*i+1, 2*j) || genTree(2*i+1, 2*j+1));
    }//end of SD
    boolean SL(int i, int j){
//
//veries if the quadtrees with the roots in the descendents of the
//descendents of coecient(i,j) are zerotrees
        return (i<dim/2 && j<dim/2) && (SD(2*i, 2*j) ||
                SD(2*i, 2*j+1) || SD(2*i+1, 2*j) || SD(2*i+1, 2*j+1));
    }//end of SL
    boolean genTree(int i, int j){
//-
//veries if the quadtree with the root in coecient(i,j) is a //zerotree
        if(Math.abs(tab[dim*i+j]) >= n)
            return true;
        else
            return SD(i,j);
    }//end of genTree
float retMax(){
//-
//computes the initial threshold
float max = 0;
        for(int i=0; i<dim*dim; i++)
            if(Math.abs(tab[i])>max)
                max = Math.abs(tab[i]);
float power = (float)Math.floor(Math.log(max)/Math.log(2));
        return (float)Math.pow(2,power);
    }//end of retMax
    void treatCoef(int k, int l)throws EndCoding, IOException{
//
//code the coecient at position (k,l)
float coef = tab[dim*k+l];
        if(Math.abs(coef) >= n){
            putBit(true);//code SN(k,l)=1
            LSP[nrLSP++] = Math.abs(coef)-n;//add coecient(k,l) to the LSP
            putBit(coef < 0);//code the sign of the coecient
        }else{
            putBit(false);//code SN(k,l)=0
            LIP[nrLIP++] = coef;
        }
    }//end of treatCoef
    void codeImage()throws IOException, EndCoding{
//
        noBitsCodif = 0;
//number of coecients added to the LSP at the previous passes
        int noLSPPrev = 0;
        n = retMax();//initialize the threshold
//write the le header
        dos.writeInt(dim);//side of the image

        dos.writeFloat(tab[0]);//general average
        dos.writeFloat(n);//initial threshold
        dos.writeFloat(bpp);//encoding bitrate
//step 1: Initialization
//Initialize the LIP
        LIP[nrLIP++] = tab[1];
        LIP[nrLIP++] = tab[dim];
        LIP[nrLIP++] = tab[dim+1];
//Initialize the LIS
        LIS.add(0,1,'A'); LIS.add(1,0,'A'); LIS.add(1,1,'A');
        do{
//Step2: Sort
            for(int i=0; i<nrLIP; i++)
//veries if the element vas not eliminated from LIP
                if(LIP[i] != Float.POSITIVE_INFINITY)
                    if(Math.abs(LIP[i]) >= n){
                        putBit(true);
//move the coecient to the LSP
                        LSP[nrLSP++] = Math.abs(LIP[i])-n;
//The previous bit 1 indicates the most signicant bit of the //coecient. This
                                putBit(LIP[i] < 0);
//disables the coecient in the LIP
                        LIP[i] = Float.POSITIVE_INFINITY;
                    }else
                        putBit(false);//the coecient remains insignicant
            boolean nextBit;//holds the next bit of the code
//process the LIS
            for(LIS.start(); LIS.current != null; LIS.next()){
                if(!LIS.current.valid)
                    continue;//step over the eliminated sets
                if(LIS.current.type == 'A'){
                    nextBit = SD(LIS.current.i, LIS.current.j);
                    putBit(nextBit);
                    if(nextBit){
//process the descendents of (i,j)
                        treatCoef(2*LIS.current.i, 2*LIS.current.j);
                        treatCoef(2*LIS.current.i+1, 2*LIS.current.j);
                        treatCoef(2*LIS.current.i, 2*LIS.current.j+1);
                        treatCoef(2*LIS.current.i+1, 2*LIS.current.j+1);
                        if(4*LIS.current.i+3<dim && 4*LIS.current.j+3<dim){
//if the direct descendents of the current node have
//descendents
                            LIS.current.type = 'B';
                            LISTypeB();
                        }else
                            LIS.current.invalidate();
                    }//end if(nextBit)
                }//end if(LIS.current.type == 'A')
                else //the set is of type B
                    LISTypeB();
            }//end the process of LIS
//step3: Renement
            for(int i=0; i<noLSPPrev; i++)
                if(LSP[i] >= n){
                    putBit(true);
                    LSP[i] -= n;
                }else
                    putBit(false);
            noLSPPrev = nrLSP;//No of coecients that will be processed at
//the next crossing of step 3
//step 4: Update the threshold
            n /= 2;
        }while(true);
    }//end of codeImage
    void LISTypeB()throws EndCoding, IOException{
//-
//code a set of type B
        boolean nextBit = SL(LIS.current.i, LIS.current.j);
        putBit(nextBit);
        if(nextBit){
            LIS.add(2*LIS.current.i, 2*LIS.current.j, 'A');
            LIS.add(2*LIS.current.i+1, 2*LIS.current.j, 'A');
            LIS.add(2*LIS.current.i, 2*LIS.current.j+1, 'A');
            LIS.add(2*LIS.current.i+1, 2*LIS.current.j+1, 'A');
            LIS.current.invalidate();
        }
    }//end of LISTypeB
    int noBitsCodif;//length of the code
    byte byteCod;//holds maximum 8 bits of the code
    void putBit(boolean theBit)throws EndCoding, IOException{
//-
//puts the next bit in the image code
        byte mask = (byte)(1 << 7 -noBitsCodif % 8);
        if(theBit)
            byteCod |=mask;
        else
            byteCod&=~mask;
        noBitsCodif++;
        if(noBitsCodif % 8 == 0){
            dos.writeByte(byteCod);
            if (noBitsCodif >= lungCod){
                dos.close();
                throw new EndCoding("End of image coding");
            }
        }
    }//end of putBit
}//end of class SPIHT
class EndCoding extends Exception
{
    //public GataCitBiti(String s){ super(s); }

    public EndCoding(String end_of_image_coding) {
        super(end_of_image_coding);
    }
}//end class EndCoding
class List{
    Node first = null, last = null, current = first;
    void add(int i, int j, char tip){//add a new node in the list
        Node a = new Node(i,j,tip,last);
        last = a;
        if(first == null)
first = last;//add the frst node in the list
    }
    void start(){ current = first; }//select the first node in the list
    Node next()
    {//select the next node in the list
        if(current != null)
            current = current.next;
        return current;
    }
}//end of class List

class Node{
    //
    int i,j;//hold the position of the root of the set
    char type;//type of the set (A or B)
    Node next;//link to the next node in the list
    boolean valid;
    Node(int i, int j, char type){
        this.i = i; this.j = j; this.type = type;
        next = null; valid = true;
    }
    Node(int i, int j, char type, Node last){
        this(i,j,type);
        if(last != null)
            last.next = this;
    }
    void invalidate(){ valid = false; }
}//end of class Node
