package navigator.algorithm;

public class Floyd {

    final static int INF = 9999, nV = 4;

    // Navigational Routes
    private double[][] directions;

    // Distance Routes
    private double[][] distances;

    public Floyd(int size) {
        directions = new double[size][size];
        distances = new double[size][size];
    }

    public double[][] getDistances() {
        return distances;
    }

    public void setDistances(double[][] distances) {
        this.distances = distances;
    }

    public double[][] getDirections() {
        return directions;
    }

    public void setDirections(double[][] directions) {
        this.directions = directions;
    }

    public void floydWarshall(double[][] graph,int size) {
        double[][] matrix = new double[graph.length][graph.length];
        int i, j, k;
        double[][] direction = new double[graph.length][graph.length];

        for (i = 0; i < graph.length; i++)
            for (j = 0; j < graph.length; j++)
                matrix[i][j] = graph[i][j];

        for (int s = 0; s < graph.length; s++) {
            int x = 0;
            for (int m = 0; m < graph.length; m++) {
                direction[s][m] = ++x;
            }
        }

        // Adding vertices individually
        for (k = 0; k < graph.length; k++) {
            int x = k;
            for (i = 0; i < graph.length; i++) {
                for (j = 0; j < graph.length; j++) {
                    if (matrix[i][k] + matrix[k][j] < matrix[i][j]) {
                        matrix[i][j] = matrix[i][k] + matrix[k][j];
                        direction[i][j] = direction[i][k];
                    }
                }
            }
        }



        setDistances(matrix);
        setDirections(direction);

    }

   public void printMatrix(double[][] matrix) {
        for (int i = 0; i < matrix.length; ++i) {
            for (int j = 0; j < matrix.length; ++j) {
                if (matrix[i][j] == INF)
                    System.out.print("INF ");
                else
                    System.out.print(matrix[i][j] + "  ");
            }
            System.out.println();

        }
    }
}
