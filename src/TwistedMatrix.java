import java.util.Scanner;

public class TwistedMatrix {

	public static void main(String args[] ) throws Exception {
        /* Sample code to perform I/O:
         * Use either of these methods for input

        //BufferedReader
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String name = br.readLine();                // Reading input from STDIN
        System.out.println("Hi, " + name + ".");    // Writing output to STDOUT
*/
        //Scanner
        Scanner s = new Scanner(System.in);
        int size = s.nextInt();                 // Reading input from STDIN
        //System.out.println("Hi, " + name + ".");    // Writing output to STDOUT
        int[] arr = new int[size*size];
        int count = 0;
        for(int i=0;i<size*size;i++){
            arr[i] = s.nextInt();
            //count++;
        }
        //System.out.print(count+" ");
        /*for(int i=0;i<arr.length;i++){
            System.out.print(arr[i]+" ");
        }*/
        for(int i=0;i<arr.length-1;i++){
            int j = i;
            while(j>=0 && arr[j+1]<arr[j]){
                int temp = arr[j+1];
                arr[j+1] = arr[j];
                arr[j] = temp;
                j--;
            }
            
        }
        
        /*for(int i=0;i<arr.length;i++){
            System.out.println(arr[i]+" ");
        }*/
        
        spiral(arr, size,size);
        // Write your code here

    }
	
	public static void spiral(int[] q,int m,int n){
        int[][] arr = new int[m][n];
        int r = 0, c = 0, pos=0;
        int i;
        while(r<m && c<n){
            for(i=c;i<n;i++){
                arr[r][i] = q[pos++];
            }
            r++;
            for(i=r;i<m;i++){
                arr[i][n-1] = q[pos++];
            }
            n--;
            if(r<m){
                for(i=n-1;i>=c;i--){
                    arr[m-1][i] = q[pos++];
                }
                m--;
            }
            if(c<n){
                for(i=m-1;i>=r;i--){
                    arr[i][c] = q[pos++];
                }
                c++;
            }
        }
        
        for(int k=0;k<arr.length;k++){
            for(int j=0;j<arr[k].length;j++){
                System.out.print(arr[k][j]+" ");
            }
            System.out.println();
        }
    }

}
