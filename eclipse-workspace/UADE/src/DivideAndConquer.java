
public class DivideAndConquer {
	
	//Metodo secuencial
	public int raiz(int n) {
		int u = 0;
		if (n <=1) {
			u = n;
		} else {
			while (u * u < n && n >= (u + 1) * (u + 1)) {
				u++;
			}
		}
		return u;
	}
	
	/*
	 *Este método en realidad es un caso de substract & conquer.
	 *Donde 'n' es el radicando y 'u' es una variable auxiliar que se 
	 *aproxima por izquierda y derecha a 'n'
	 *Nota: 'n' debe ser mayor o igual que 0.
	 */
	
	public int raizRecursiva(int n, int u) {
		if(n<=1) {
			return n;
		}else if(Math.pow(u, 2) < n && n >= Math.pow(u+1, 2)) {
				u++;
				u=raizRecursiva(n,u);
		}
		return u;
	}
	
	/*
	 * Algoritmo de Euclides:
	 */
	public int maximoComunDivisor(int m, int n) {
		if(n!=0) {
		int r=0;
		r=m%n;
		if(r==0) {
			return n;
		}else {
			m=n;
			n=r;
			n=maximoComunDivisor(m,n);
		}
		}
		return n;	
	}
	/*
	 * Factorial:
	 * Donde 'n' es mayor o igual que 0.
	 */
	public int factorialRecursivo(int n) {
		if(n>=0) {
			if(n==0 || n==1) {
				return 1;
			}else {
				n*=factorialRecursivo(n-1);
			}
		}
		return n;
	}
	/*
	 * Fibonacci: 1,2,3,5,8,13,21,34,55,89,144...
	 * a=1;
	 * b=1;
	 * a=1;
	 * b+=a;
	 * a+=b;
	 */
	public void secuenciaFibonacci(int n) {
		int a,b;
		a=0;
		b=1;
		System.out.print("Calculo de "+n+" elementos de la secuencia de Fibonacci:");
		while(n>0) {
			a+=b;
			System.out.print(" "+a);
			n--;
			if(n>0) {
			b+=a;
			System.out.print(" "+b);
			} 
			n--;
		}		
		System.out.print(". (Método no recursivo)");
	}
	
	public int fibonacciRecursivo(int n)  {
	    if(n == 0 || n==1) {
	        return 1;
	    }else {
	      return fibonacciRecursivo(n - 1) + fibonacciRecursivo(n - 2);
	    }
	}
	
	public static void main(String[] args) {
		int n=5, m=125;
		DivideAndConquer testMetodos = new DivideAndConquer();
		System.out.println("\n");
		System.out.println("Raíz entera de "+n+" es: "+testMetodos.raiz(n)+". (Método no recursivo)");
		System.out.println("Raíz entera de "+n+" es: "+testMetodos.raizRecursiva(n, 0)+". (Método recursivo)");
		System.out.println("El máximo común divisor entre "+m+" y "+n+" es: "+testMetodos.maximoComunDivisor(m,n)+". (Método recursivo)");
		System.out.println("Factorial de "+n+" es: "+testMetodos.factorialRecursivo(n)+". (Método recursivo)");
		testMetodos.secuenciaFibonacci(n);
		System.out.print("\nEl elemento de la secuencia de Fibonacci en la posición "+n+" es: "+testMetodos.fibonacciRecursivo(n)+". (Método recursivo)");
	}
}