package jsj.tysf;
public class Div extends Operator{

	@Override
	public double operator(double a, double b) {
		// TODO Auto-generated method stub
		if(b!=0){
		return a/b;
		}else{
			System.out.println("除数不能为零");
			return b;
		}
	}

}
