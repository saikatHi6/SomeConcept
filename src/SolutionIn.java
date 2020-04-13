import java.security.Permission;

public class SolutionIn {

	public static void main(String args[]){

        try{        
          

        	Inner in = new Inner();
        	Inner.Private ip = in.new Private();
        	int n = 8;
        	
        	System.out.println(n+ " is a "+ip.powerof2(n));
        	System.out.println("An instance of class: " + ip.getClass().getCanonicalName() + " has been created");
        	
		}//end of try
		
		catch (DoNotTerminate.ExitTrappedException e) {
			System.out.println("Unsuccessful Termination!!");
		}
	}//end of main
	static class Inner{
		private class Private{
			private String powerof2(int num){
				return ((num&num-1)==0)?"power of 2":"not a power of 2";
			}
		}
	}//end of Inner
	
}//end of Solution

class DoNotTerminate { //This class prevents exit(0)
	 
    public static class ExitTrappedException extends SecurityException {

		private static final long serialVersionUID = 1L;
    }
 
    public static void forbidExit() {
        final SecurityManager securityManager = new SecurityManager() {
            @Override
            public void checkPermission(Permission permission) {
                if (permission.getName().contains("exitVM")) {
                    throw new ExitTrappedException();
                }
            }
        };
        System.setSecurityManager(securityManager);
    }
	
}
