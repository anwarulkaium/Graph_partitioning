import mpi.*;

public class bcast {
  static public void main(String[] args) throws Exception {
    try {
      bcast c = new bcast(args);
    }
    catch (Exception e) {
    }
  }

  public bcast() {
  }

  public bcast(String[] args) throws Exception {

    final int MAXLEN = 10000;

    int root, i, j, k;
    int out[] = new int[MAXLEN];
    int myself, tasks;
    double time;

    MPI.Init(args);
    myself = MPI.COMM_WORLD.Rank();
    tasks = MPI.COMM_WORLD.Size();

    root = tasks - 1;
    for (j = 1; j <= MAXLEN; j *= 10) {
      if (myself == root)
	for (i = 0; i < j; i++) 
		//System.out.println(" Root " + i);
	  out[i] = i;
	  //}
      MPI.COMM_WORLD.Bcast(out, 0, j, MPI.INT, myself);
      System.out.println(" J "+ j+ " Rank "+ myself);
      for (k = 0; k < j; k++) {
	if (out[k] != k) {
	  System.out.println("bad answer (" + (out[k]) + ") at index " + k
	      + " of " + j + " (should be " + k + ")");
	  break;
		}
      }
    }

    MPI.COMM_WORLD.Barrier();
    if (myself == 0)
      System.out.println("Bcast TEST COMPLETE");
    MPI.Finalize();
  }
}