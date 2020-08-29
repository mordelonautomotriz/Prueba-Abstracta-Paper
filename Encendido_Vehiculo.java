package encendido_vehiculo;
import java.util.Scanner;

abstract class Bobina_Encendido{
    private int codigo_bobina_1_2;
    private int codigo_bobina_3_4;
    private float tension_1_2;
    private float tension_3_4;
    private float tension_referencia;
    private String diagnostico;
    
    public Bobina_Encendido(float tension_referencia) {
        tension_referencia=(float) 5.0;
    } 
public Bobina_Encendido(int codigo_bobina_1_2, int codigo_bobina_3_4, float tension_1_2, float tension_3_4, float tension_referencia, String diagnostico){
    
        this.codigo_bobina_1_2 = codigo_bobina_1_2;
        this.codigo_bobina_3_4 = codigo_bobina_3_4;
        this.tension_1_2 = tension_1_2;
        this.tension_3_4 = tension_3_4;
        this.tension_referencia = tension_referencia;
        this.diagnostico = diagnostico;
    }
    

    public int getCodigo_bobina_1_2() {
        return codigo_bobina_1_2;
    }

    public void setCodigo_bobina_1_2(int codigo_bobina_1_2) {
        this.codigo_bobina_1_2 = codigo_bobina_1_2;
    }

    public int getCodigo_bobina_3_4() {
        return codigo_bobina_3_4;
    }

    public void setCodigo_bobina_3_4(int codigo_bobina_3_4) {
        this.codigo_bobina_3_4 = codigo_bobina_3_4;
    }

    public float getTension_1_2() {
        return tension_1_2;
    }

    public void setTension_1_2(float tension_1_2) {
        this.tension_1_2 = tension_1_2;
    }

    public float getTension_3_4() {
        return tension_3_4;
    }

    public void setTension_3_4(float tension_3_4) {
        this.tension_3_4 = tension_3_4;
    }

    public float getTension_referencia() {
        return tension_referencia;
    }

    public void setTension_referencia(float tension_referencia) {
        this.tension_referencia = tension_referencia;
    }

    public String getDiagnostico() {
        return diagnostico;
    }

    public void setDiagnostico(String diagnostico) {
        this.diagnostico = diagnostico;
    }
}
   class TensionBobina extends Bobina_Encendido{
       private float diferencia_tension; 
       
public TensionBobina(int codigo_bobina_1_2, int codigo_bobina_3_4, float tension_1_2, 
float tension_3_4, float tension_referencia, String diagnostico,float diferencia_tension){

        super(codigo_bobina_1_2, codigo_bobina_3_4, tension_1_2, tension_3_4, 
        tension_referencia, diagnostico);
        
        TensionBobina.super.setTension_referencia(tension_referencia);
        setDiferencia_tension(diferencia_tension);
    }

    public float getDiferencia_tension() {
        return diferencia_tension;
    }

    public void setDiferencia_tension(float diferencia_tension) {
        this.diferencia_tension = diferencia_tension;
    }
       
       
    public void DeterminarTension(){
     if (getTension_1_2()>getTension_referencia()){
TensionBobina.super.setDiagnostico(" Revisar la linea de de alimentacion.");
System.out.println("______________________________________");
System.out.println("El cuerpo de bobinas [1-2] con codigo: "
        + ""+getCodigo_bobina_1_2()+" Presenta una tension"
+" \n mas elevada del rango de trabajo normal."+" Diagnostico: "+getDiagnostico());    
     }else{
System.out.println("______________________________________");
System.out.println("El cuerpo de bobinas [1-2] con codigo: "
        + ""+getCodigo_bobina_1_2()+" Funciona normalmente");
     }
     if (getTension_3_4()>getTension_referencia()){
         TensionBobina.super.setDiagnostico(" Revisar la linea de de alimentacion.");
         System.out.println("______________________________________");
System.out.println("El cuerpo de bobinas [3-4] con codigo: "
        + ""+getCodigo_bobina_3_4()+" Presenta una tension"
        +" \n mas elevada del rango de trabajo normal."+" Diagnostico: "+getDiagnostico());    
     }else{
         System.out.println("______________________________________");
         System.out.println("El cuerpo de bobinas [3-4] con codigo: "
                 + ""+getCodigo_bobina_3_4()+" Funciona normalmente");
            }    
        }
    
   }
class Motor extends Bobina_Encendido{
    private String tipo_motor;
    public Motor(float tension_referencia, String tipo_motor){
    super(tension_referencia);
    Motor.super.setTension_referencia(tension_referencia);
    setTipo_motor(tipo_motor);
}

    public String getTipo_motor() {
        return tipo_motor;
    }

    public void setTipo_motor(String tipo_motor) {
        this.tipo_motor = tipo_motor;
    }
    public void DeterminarMotor(){
        
    }
    
}


public class Encendido_Vehiculo {

    public static void main(String[] args) {
        
        Scanner sc=new Scanner(System.in);
        
        Bobina_Encendido vehiculo = new Bobina_Encendido((float) 5.0) {};
        TensionBobina tension =new TensionBobina(112,114, 6,3, (float) 5.0,"2", 0b1);
        Motor motor1=new Motor((float) 5.0,"BN400");
        System.out.println("____________________");
        System.out.println("---------[UNIVERSIDAD DE LAS FUERZAS ARMADAS ESPE]---------");
        System.out.println("ASIGNATURA: PROGRAMACION");
        System.out.println("DOCENTE: ING. LUIS ALBERTO GUERRA CRUZ");
        System.out.println("NRC: 7450");
        System.out.println("NOMBRE:");
        System.out.println("-----> STALYN ALVAREZ");
        System.out.println("-----> HECTOR ORTIZ");
       
        System.out.println("Ingrese el codigo del cuerpo de bobinas [1-2]");
        int codigo_1_2=sc.nextInt();
        System.out.println("Ingrese el valor de tension del cuerpo de bobinas [1-2]");
        float t_1_2=sc.nextFloat();
        
        System.out.println("Ingrese el codigo del cuerpo de bobinas [3-4]");
        int codigo_3_4=sc.nextInt();
        System.out.println("Ingrese el valor de tension del cuerpo de bobinas [3-4]");
        float t_3_4=sc.nextFloat();
        
        vehiculo.setCodigo_bobina_1_2(codigo_1_2);
        vehiculo.setTension_1_2(t_1_2);
        vehiculo.setCodigo_bobina_3_4(codigo_3_4);
        vehiculo.setTension_3_4(t_3_4);
        tension.DeterminarTension();
        motor1.DeterminarMotor();      
    }   
}