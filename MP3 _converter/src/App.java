import it.sauronsoftware.jave.AudioAttributes;
import it.sauronsoftware.jave.Encoder;
import it.sauronsoftware.jave.EncoderException;
import it.sauronsoftware.jave.EncodingAttributes;

import java.io.File;

public class App
{
    public static void Convert_To_Audio(File video) throws EncoderException
    {
        System.out.println("the Conversion is started");
        File Audio = new File("ok.mp3");
        AudioAttributes audio = new AudioAttributes();
        audio.setCodec("libmp3lame"); //Sets the codec name for the encoding process. If null or not specified the encoder will perform a direct stream copy.
        audio.setBitRate(128000); //Sets the bitrate value for the encoding process. If null or not specified a default value will be picked.
        audio.setChannels(2);//Sets the channels value (1=mono, 2=stereo) for the encoding process. If null or not specified a default value will be picked.
        audio.setSamplingRate(44100);

        EncodingAttributes attribute = new EncodingAttributes();
        attribute.setFormat("mp3");
        attribute.setAudioAttributes(audio); // Sets the attributes for the encoding of the audio stream in the target multimedia file. If null of not specified no audio stream will be encoded. It cannot be null if also the video field is null.

        Encoder encode = new Encoder();
        try
        {
            encode.encode(video,Audio,attribute);
            System.out.println("Conversion is completed");
        }
        catch(Exception exp)
        {
            System.out.println("Error Occured");
            System.err.println(exp.toString());
        }
    }
}
