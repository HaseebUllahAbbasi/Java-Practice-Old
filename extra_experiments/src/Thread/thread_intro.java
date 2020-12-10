package Thread;

/*
concurrency is the ability to run several programs or several parts of a program in parallel
.. achieve high performance
..one CPU, program can utilize all cores for some part of processing
process
A process has a self-contained execution environment. 
 A process generally has a complete, private set of basic run-time resources;
 each process has its own memory space.

 Threads>.
 Threads are sometimes called lightweight processes. 

but creating a new thread requires fewer resources than creating a new process.

Threads exist within a process — every process has at least one
hreads share the process's resources, including memory and open files.

..Multithreaded execution
This thread has the ability to create additional threads,


Thread Objects
1. To directly control thread creation and management, simply instantiate Thread each time the application needs to initiate an asynchronous task.
2. To abstract thread management from the rest of your application, pass the application's tasks to an executor

Defining and Starting a Thread

Provide a Runnable object. The Runnable interface defines a single method, run, meant to contain the code executed in the thread. The Runnable object is passed to the Thread constructor, as in the HelloRunnable example:




*/
public class thread_intro implements Runnable
{
	
	public void start()
	{
		System.out.println("the start is called");
	}

    public void run() {
        System.out.println("Hello from a thread!");
    }

    public static void main(String args[]) {
        (new Thread(new thread_intro())).start();
    	thread_intro obj = new thread_intro();
    	obj.start();

    }

}