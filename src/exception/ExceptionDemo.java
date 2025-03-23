package exception;


import java.util.InputMismatchException;

public class ExceptionDemo {

	public static void main(String[] args) throws InputMismatchException{
		
		
		int i =5;
		int j =0;
		int age=16;
	int result=0;
		try {
			
			
//			if(j==0) {
//				throw new NumberFormatException();       
//			}
			
			
			if(age < 18) {
		throw new MinimumAgeException ("Age should not be less than 18");
		}
			
		 result = i/j;
		}
           catch(ArithmeticException | MinimumAgeException | NumberFormatException e ) {   // all Exception
			if(e instanceof ArithmeticException) {
			System.out.println("an Arithmetic execution occurred!!");
			
			}
			else if (e instanceof MinimumAgeException){
				System.out.println(e.getMessage());

			}
			else if (e instanceof NumberFormatException){
				System.out.println("an Number Format execution occurred!!");

			}

			
		}

		
//		catch(ArithmeticException e) {   //only for ArithmeticException
//			
//			System.out.println("an Arithmetic execution occurred!!");
//
//			
//		}
//		catch(MinimumAgeException e) {   //only for MinimumAgeExceptio
//			
//			System.out.println(e.getMessage());
//
//		
//		}
//		
//		catch(NumberFormatException e) {   //only for NumberFormatException
//			
//			System.out.println("an Number Format execution occurred!!");
//
//			
//		}
//		catch(Exception e) {   // for all Exception
//			
//			System.out.println(" execution occurred!!");
//
//			
//		}
	    finally {
			System.out.println(" execution finally occurred!!");

	    }
		
		System.out.println("execution resumes      result="+ result);

	}

}
