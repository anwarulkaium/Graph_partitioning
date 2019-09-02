import mpi.*;

public class Barrier {
  static public void main(String[] args) throws Exception {
    try {
      Barrier c = new Barrier(args);
    }
    catch (Exception e) {
    }
  }

  public Barrier() {
  }

  public Barrier(String[] args) throws Exception {

    int me, tasks, i;

    MPI.Init(args);
    me = MPI.COMM_WORLD.Rank();
    tasks = MPI.COMM_WORLD.Size();

    if (tasks < 2) {
      System.out.println("MUST RUN WITH AT LEAST 2 TASKS");
      System.exit(0);
    }

    for (i = 0; i < 250000 * me; i++);

    System.out.println(" TASK " + me + " BEFORE BARRIER, TIME = "
	+ (MPI.Wtime()));
    
    MPI.COMM_WORLD.Barrier();

    System.out.println(" TASK " + me + " AFTER  BARRIER, TIME = "
	+ (MPI.Wtime()));

    if (me == 0)
      System.out.println("Barrier TEST COMPLETE");
    MPI.Finalize();
  }
}
