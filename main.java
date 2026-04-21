
/*Cargue un arreglo con n elementos y desplace sus elementos un lugar hacia su derecha,
teniendo en cuenta que el último componente se ha de desplazar al primer lugar. */
import java.io.*;
class Proceso {
    private int v[];
    
    void Arreglo3 (int limite){ 
        int cant;
        cant=limite;
        v = new int[cant];
    }
    public void asignar(int i, int dato){
        v[i]=dato;
    }

    public void desplazar(int cant){
        int ultimo = v[cant-1];
        for (int i = cant-1; i > 0; i--){
            v[i] = v[i-1];
        }
        v[0] = ultimo;
    }

    public int getV(int i){
        return v[i];
    }
    
}
class Main {
    public static void main (String []arg){
        BufferedReader br = new BufferedReader (new InputStreamReader(System.in));
        Proceso obj = new Proceso();
        int cantElem=0, num=0;
        boolean error;
        do{
            try{
                System.out.println("Ingrese la cantidad de elementos:");
                cantElem = Integer.parseInt(br.readLine());
                if(cantElem<=0){
                    System.out.println("Error.. la cantidad debe ser mayor a 0");
                    error=true;
                }
                else{
                    error=false;
                    obj.Arreglo3(cantElem);
                }
            }
            catch(IOException | NumberFormatException e){
                System.out.println("Error... en la entrada de datos");
                error=true;
            }
        }while(error==true);

        for(int i=0; i<cantElem;i++){
            try{
                System.out.println("Ingrese el numero del elemento "+ i+1 + " :");
                num=Integer.parseInt(br.readLine());
                obj.asignar(i, num);
            }
            catch(IOException | NumberFormatException e ){
                System.out.println("Error..en la entrada de datos");
                i--;
            }
        }

        obj.desplazar(cantElem);
        System.out.println("\nArreglo desplazado a la derecha:");
        for(int i=0; i<cantElem;i++){
            System.out.print("["+obj.getV(i)+"]");
        }
        System.out.print("Modificación");
    }
}