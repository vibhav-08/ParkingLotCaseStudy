import java.io.* ;
import java.util.*;
import java.text.*;
import java.util.concurrent.TimeUnit;

//-----------------------------------------------------------------------------------------------------------------------------------------------------//
interface display
{
    // displayfunction method in interface to use it to define display in different classes
    void displayfunction();
}
class ParkType
{   
    private int parkingtypeid;
    private String parkingtype;
    private int hourlycharges;
    // intialising all the private variables through constructor
    ParkType(int parkingtypeid,String parkingtype,int hourlycharges)
    {
        this.parkingtypeid = parkingtypeid;
        this.parkingtype = parkingtype;
        this.hourlycharges = hourlycharges;
    }
    // creating getter methods for ParkingTypeID(int),ParkingType(int),HourlyCharges(int)
    public int getterparkingtypeid()
    {
       return parkingtypeid;
    }
    public String getterparkingtype()
    {
       return parkingtype;
    }
    public int getterhourlycharges()
    {
       return hourlycharges;
    }
}

//-----------------------------------------------------------------------------------------------------------------------------------------------------//

class CheckPoints
{
    protected int CheckPointsID;
    protected int EntryType;
    protected String address;
    // intialising all the protected variables through constructor 
    CheckPoints(int CheckPointsID, int EntryType,String address)
    {
    this.CheckPointsID=CheckPointsID;
    this.EntryType=EntryType;
    this.address=address;
    }
}

//-----------------------------------------------------------------------------------------------------------------------------------------------------//
class Pkspot
{
   protected int Parkingspotid;
   protected int Floornumber;
   protected  int Parkingtype;
   protected boolean isOcccupied;
    // intialising all the protected variables through constructor
    Pkspot(int Parkingspotid,int Floornumber,int Parkingtype, boolean isOcccupied)
    {
        this.Parkingspotid = Parkingspotid;
        this.Floornumber = Floornumber;
        this.Parkingtype = Parkingtype;
        this.isOcccupied = isOcccupied;
    }

}
//-----------------------------------------------------------------------------------------------------------------------------------------------------//

class Transaction{
    protected int ticketnumber;
    protected String name;
    protected String VehicleNumber;
    protected String Entrydate;
    protected String Entime;
    protected String Extime;
    protected int ParkingType;
    protected int EntryPoint;
    protected int ExitPoint;
    protected int Floornumber;
    protected int Spotnumber;
    protected boolean ispayed;
    
    // intialising all the protected variables through constructor
    Transaction(String name,String VehicleNumber,int ParkingType,int EntryPoint,int ExitPoint,boolean ispayed,int Floornumber,int Spotnumber,int tknum){
        this.ticketnumber=tknum;
        this.name=name;
        this.VehicleNumber = VehicleNumber;
        this.Floornumber = Floornumber;
        this.Spotnumber = Spotnumber;
        this.ParkingType = ParkingType;
        this.EntryPoint = EntryPoint;
        this.ExitPoint = ExitPoint;
        this.ispayed = ispayed;
        setentrytime();
        setexittime();
        setdate();
    }
    // method to set entry time
    protected void setentrytime()
    {   SimpleDateFormat formatter = new SimpleDateFormat("kk:mm:ss");
        Date EntryTime = new Date();
        this.Entime = formatter.format(EntryTime.getTime());
    }
    //method to set exit time
    protected void setexittime()
    {   
        this.Extime = "NULL";
    }
    //method to set date
    protected void setdate()
    {
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
        Date Entrydate = new Date();
        this.Entrydate  = dateFormat.format(Entrydate.getTime());
    }   
}
//-----------------------------------------------------------------------------------------------------------------------------------------------------//

class ParkTypeArray implements display
{
    protected ArrayList<ParkType> Pt = new ArrayList<ParkType>();// creating array list of parkType
    int pid[] = {1,2,3,4,5};
    String ptype[]={ "COMPACT(CAR)","LARGE(TRUCK/BUS)","HANDICAPPED","MOTORBIKE(SCOOTY/BIKE)","ELECTRICCAR"};
    int hcharges[]={20,30,6,10,8};
    // Assigning parking ID to parking types and their corresponding hourly charges
    ParkTypeArray()
    {
    for(int i=0;i<5;i++)
        {
            Pt.add(new ParkType(pid[i], ptype[i], hcharges[i]));

        }
    }
    // method to add parking type by taking ParkingID(int),ParkingType(string),HourlyCharge(int) in future if required
    protected void addparktype(int t, String s, int l)
    {   ParkType b = new ParkType(t,s,l);
        Pt.add(b);
    }
    // method to return charges of a VehicleType by taking parkingtypeid(int)
    public int returnCharge(int number)
    {   
        for(int i=0;i<Pt.size();i++) 
        {   
             if(Pt.get(i).getterparkingtypeid()==number)
            {   
                return Pt.get(i).getterhourlycharges();
            }
        }
        return 0;
       
    }
    // method to delete parking type
    protected boolean deleteparktype(int number)
    {  int stuff=-1;
        for(int i=0;i<Pt.size();i++) 
        {
            if(Pt.get(i).getterparkingtypeid()==number)
            {
                stuff=i;
            }
        }
        if(stuff!=-1)
        {   Pt.remove(stuff);
            return true;
        }
        return false;
        
    }
    // method to display all VehicleType ID & corresponding vehicle type
    public void displayfunction()
    {   System.out.println();
        System.out.println(" VEHICLE TYPE BOARD");
        System.out.println();
        System.out.println("ID "+"    VEHICLETYPE");
        for(int i=0;i<Pt.size();i++)
            {
                System.out.println(Pt.get(i).getterparkingtypeid() +"      "+ Pt.get(i).getterparkingtype());
            }
    }
    //method to display avaialble parking spot of a vehicle type 
    public void utility(int ParkingType)
    {
        
        int k = -1;
        if(ParkingType<=Pt.size())
        {   System.out.println();
            for(int i=0;i<Pt.size();i++)
            { 
                if( Pt.get(i).getterparkingtypeid() == ParkingType)
                {
                    k=i;
                    break;
                }
            }
            System.out.println("                    "+Pt.get(k).getterparkingtype()+" VEHICLE AVAILABILITY BOARD");
            System.out.println();
            System.out.println();
            System.out.println("DISCLAIMER: F1-P1 IS FLOOR 1 PARKINGSPOT 1");
        }
        else{
            System.out.println("There is no such category!!");
        }

    }
}

//-----------------------------------------------------------------------------------------------------------------------------------------------------//

class checkPointArray
{
    protected ArrayList<CheckPoints>CheckPointID =new ArrayList<CheckPoints>();
    public int cp[]={1,1,2,2,3,3,4,4};
    public int Ext[]={1,2,1,2,1,2,1,2};
    public String[] Adress={"BLOCK A ENTRY","BLOCK A EXIT","BLOCK B ENTRY","BLOCK B EXIT","BLOCK C ENTRY","BLOCK C EXIT","BLOCK D ENTRY","BLOCK D EXIT"};
    // merging check points, exit point and address
    checkPointArray(){
    for(int i=0;i<8;i++)
        {
            CheckPointID.add(new CheckPoints(cp[i], Ext[i],Adress[i]));

        }
    }
    // method to add check point by taking checkPoint(int),Address(String),exitPOint(int) in future if required
    protected void addcheckpoint(int t,String b,int type)
    {   
        if(type==1)
        CheckPointID.add(new CheckPoints(t,1,b));
        else{
          CheckPointID.add(new CheckPoints(t,2,b));  
        }
    }
    // method to remove checkpoint by taking checkPointID(int) & entryType(int)
    protected boolean removecheckpoint(int number,int k)
    {
        int stuff=-1;
        for(int i=0;i<CheckPointID.size();i++) 
        {
            if(CheckPointID.get(i).CheckPointsID==number &&CheckPointID.get(i).EntryType ==k )
            {
                stuff=i;
            }
        }
        if(stuff!=-1)
        {   CheckPointID.remove(stuff);
            return true;
        }
        return false;
    }
    // method to display details of entry point
    public void entrydisplay()
    {
        System.out.println();
        System.out.println("   ENTRYPOINT MENU");
        System.out.println();
        System.out.println("CID "+ "  BLOCK TYPE");
        for(int i=0;i<CheckPointID.size();i++)
        {
            CheckPoints data1 =CheckPointID.get(i);
            if(data1.EntryType==1)
           
            System.out.println(data1.CheckPointsID +"     "+ data1.address);
        }
    }
    // method to display details of exit point
    public void exitdisplay()
    {   System.out.println();
        System.out.println("   EXITPOINT MENU");
        System.out.println();
        System.out.println("CID "+ "  BLOCK TYPE");
        for(int i=0;i<CheckPointID.size();i++)
        {
            CheckPoints data1 =CheckPointID.get(i);
            if(data1.EntryType==2)
           
            System.out.println(data1.CheckPointsID +"     "+ data1.address);
        }
    }
}


//-----------------------------------------------------------------------------------------------------------------------------------------------------//
class FloorsArray extends ParkTypeArray implements display
{   
   protected ArrayList<Pkspot> FLOORS = new ArrayList<Pkspot>();

    public int PSID[]={1,1,1,1,1,2,2,2,2,2,3,3,3,3,3,4,4,4,4,4,5,5,5,5,5};
    //Assigning 25 parking spots to each floor where 5 spots is assigned to a particular Parking spot i.e 5*5=25
    FloorsArray()
    {   
        
        for(int i=0;i<75;i++)
        {   if(i<25)
            {
                FLOORS.add(new Pkspot(i+1,1,PSID[i],false));
            }
            else if(i<50 && i>=25)
            {
                FLOORS.add(new Pkspot(i+1,2,PSID[i-25],false));
            }
            else if(i<75 && i>=50)
            {
                FLOORS.add(new Pkspot(i+1,3,PSID[i-50],false));
            }
        }
    }
    // method to add additional floors by taking size(int),VehicleTypeID(int),floorNUMber(int) in future if required
    protected void addFloors(int n,int vtypeid,int floornumber)
    {   int k =FLOORS.size();
        for(int i=k;i<k+n;i++)
        {
            FLOORS.add(new Pkspot(i+1,floornumber,vtypeid,false));
        }

    }
    // method to remove parking spot by taking that spot(int)
    protected boolean removespot(int spot)
    {
         int stuff=-1;
         for(int i=0;i<FLOORS.size();i++) 
        {
            if(FLOORS.get(i).Parkingspotid ==spot)
            {
                stuff=i;
            }
        }
        
         if(stuff!=-1)
        {   FLOORS.remove(stuff);
         return true;
         }
         return false;
     }
    //  method to display whether a parking spot is occupied or not
    public void displayfunction()
    {   System.out.println("ID  FNO  PTYPE  ISOCCUPIED");
        for(int i=0;i<FLOORS.size();i++)
        {   
            Pkspot data2 =FLOORS.get(i);
            System.out.println(data2.Parkingspotid+"    "+ data2.Floornumber+ "    "+ data2.Parkingtype+"    "+data2.isOcccupied);
        }
    }

    // method to display all the details of parking spots
    public void displayall(int ParkingType)
    {   int count =0;
        for(int i=0;i<FLOORS.size();i++)
        {  
            Pkspot data2 =FLOORS.get(i);
           
            if(data2.isOcccupied==false && data2.Parkingtype==ParkingType)
            {
                System.out.print("F"+data2.Floornumber+"-P"+data2.Parkingspotid+" --> "+"FREE       ");
                count++;
            }
            else if(data2.isOcccupied==true && data2.Parkingtype==ParkingType){
                System.out.print("F"+data2.Floornumber+"-P"+data2.Parkingspotid+" --> "+"TAKEN       " );
                count++;
            }
            if(count==5)
            {   
                System.out.println();
                System.out.println();
                count=0;   
            }
        }
        System.out.println();
        
    }

    public int f = 0;// f is floor number
    public int s = 0;// s is spot number
    public Boolean status1 = false;
    public Boolean status2 = false;
    // method to assign parking spot by taking his vehicleType i.e parkingType(int)
    protected void assignSpot(int ParkingType){
        
        for(int i = 0; i<FLOORS.size() ; i++){  
            Pkspot d = FLOORS.get(i);
            if(d.Parkingtype == ParkingType && !d.isOcccupied){
                f = d.Floornumber;
                s = i+1;
                status1 = true;
                d.isOcccupied = true;
                break;
            }

            else{
                status1 = false;
                continue;
            }
        }
        if(!status1){
            System.out.println();
            System.out.println("THE PARKING LOT IS FULL");
        }
        
            
        
    }
    //---------------//
    // method to self assign spot that is customer can choose his spot by giving the spot(int) he want and parkingType(int) 
    protected void SelfAssign(int a,int ParkingType){
        for(int i = 0; i<FLOORS.size() ; i++)
        {
            Pkspot d = FLOORS.get(i);
            if(d.Parkingspotid==a)
            {
                if(d.Parkingtype == ParkingType && !d.isOcccupied){
                f = d.Floornumber;
                s = a;
                d.isOcccupied = true;
                status2 = true;
                }
                else
                {
                    
                    status2 = false;
                    continue;
                }
            }
        }
         if(!status2){
            System.out.println();
            System.out.println("The parking space is Full / The entered number is not in the category");
        }
        
       
    }
    
    //---------------//

}
//-----------------------------------------------------------------------------------------------------------------------------------------------------//


class payment extends ParkTypeArray{
   
    private ArrayList<Transaction> TransacArray = new ArrayList<Transaction> ();
    // method to check whether a customer has payed the charges or not by taking his TicketNo(int)  
    protected int checker(int n)
    {   for(int i=0;i<TransacArray.size();i++)
        {
            Transaction tsacobj = TransacArray.get(i);
            if(tsacobj.ticketnumber==n)
            {
                if(tsacobj.ispayed==false)
                {   
                    return 0;
                }
                else{
                    
                    return 1;
                }
            }
           
        }
        
         return 2;
        
    }
    protected void addparktype(String nm,String vnum,int inp1 ,int ennum, int exnum,int fnum,int spotnum,int tknum)
    {
        
        TransacArray.add(new Transaction(nm,vnum,inp1,ennum,exnum,false,fnum,spotnum,tknum));
    }
    // method to change his payment status after paying charges by taking his TicketNo(int)
    protected  void changePaymentStatus(int n)
    {   
        
        
        for(int i=0;i<TransacArray.size();i++)
        {   Transaction tsacobj = TransacArray.get(i);
            if(tsacobj.ticketnumber==n)
            {
                tsacobj.ispayed=true;
            }
        }

    }
    //method to change exit point by taking ticketNo(int),exitPoint(int)
    protected void changeexpoint(int tracticketnumber , int exp)
    {
        int pstat=0;
        for(int i=0;i<TransacArray.size();i++)
        {   Transaction d = TransacArray.get(i);
            
            if(d.ticketnumber==tracticketnumber)
            {
                pstat=1;
                d.ExitPoint=exp;
            }
        }
        if(pstat==0)
        {
            System.out.println("NO SUCH TICKETNUMBER PRESENT PLEASE TRY AGAIN");     
        }

    }
    //method to dispaly the details of Transaction by taking his ticketNo(int)
    public void displayTransactionInfo(int tracticketnumber)
    {
        int pstat=0;
        for(int i=0;i<TransacArray.size();i++)
        {   Transaction d = TransacArray.get(i);
            
            if(d.ticketnumber==tracticketnumber)
            {
                pstat=1;
                System.out.println("THE TICKETNUMBER IS: "+ d.ticketnumber);
                System.out.println("THE DATE IS: "+ d.Entrydate);
                System.out.println("YOUR NAME IS: "+d.name.toUpperCase());
                System.out.println("YOUR VEHICLE NUMBER IS: "+ d.VehicleNumber.toUpperCase());
                System.out.println("YOUR ENTRY TIME WAS: "+ d.Entime);
                System.out.println("YOUR EXIT TIME WAS: "+d.Extime);
                System.out.println("YOUR FLOOR NUMBER IS: "+ d.Floornumber);
                System.out.println("YOUR SPOT NUMBER IS: "+ d.Spotnumber);

                if(d.ispayed==true)
                {
                System.out.println("YOUR PAYMENT STATUS: "+ " PAYED");
                }
                else
                {
                System.out.println("YOUR PAYMENT STATUS: "+ "UNPAYED") ; 
                }
                System.out.println();
               break;
            }
        }
        if(pstat==0)
        {
            System.out.println("NO SUCH TICKETNUMBER PRESENT PLEASE TRY AGAIN");     
        }
    }
    // method to display Payment details by taking VehicleNo(string)
    public void dispbaseonvnum(String vnumber)
    {   int pstat=0;
        String temp = vnumber.toUpperCase();
        for(int i=0;i<TransacArray.size();i++)
        {   Transaction d = TransacArray.get(i);
           
            if(d.VehicleNumber.toUpperCase().equals(temp))
            {
                pstat=1;
                System.out.println("THE TICKETNUMBER IS: "+ d.ticketnumber);
                System.out.println("THE DATE IS: "+ d.Entrydate);
                System.out.println("YOUR NAME IS: "+d.name.toUpperCase());
                System.out.println("YOUR VEHICLE NUMBER IS: "+ d.VehicleNumber.toUpperCase());
                System.out.println("YOUR ENTRY TIME WAS: "+ d.Entime);
                System.out.println("YOUR EXIT TIME WAS: "+d.Extime);
                System.out.println("YOUR FLOOR NUMBER IS: "+ d.Floornumber);
                System.out.println("YOUR SPOT NUMBER IS: "+ d.Spotnumber);
                if(d.ispayed==true)
                {
                System.out.println("YOUR PAYMENT STATUS: "+ " PAYED");
                }
                else
                {
                System.out.println("YOUR PAYMENT STATUS: "+ "UNPAYED") ; 
                }
                System.out.println();
               break;
            }
        }
        if(pstat==0)
        {
            System.out.println("NO SUCH VEHICLE NUMBER PRESENT PLEASE TRY AGAIN");     
        }
        
    }

    // method to return ParkingType by taking TicketNO
    protected int returnPType(int tknum){
        for(int i=0;i<TransacArray.size();i++)
        {   Transaction dd = TransacArray.get(i);
            if(dd.ticketnumber == tknum){
                return dd.ParkingType;
            }
        }
        return 0;
    }
    // method which returns the total amount customer has to pay by taking TicketNo(int),no of hours he parked(int)
    protected float moneycalc(int ticknum,int Hourch)
    {
        for(int i=0;i<TransacArray.size();i++)
        {   Transaction dd = TransacArray.get(i);
            
            int ptype = returnPType(ticknum);
            if(dd.ticketnumber == ticknum)
            {
                if(!dd.ispayed)
                {
                String enttime = dd.Entime;  
                String exttime = dd.Extime;
                int enthour = Integer.parseInt(enttime.substring(0, 2));
                int exthour = Integer.parseInt(exttime.substring(0, 2));
                int entmin = Integer.parseInt(enttime.substring(3, 5));
                int extmin = Integer.parseInt(exttime.substring(3, 5));
                int entsec = Integer.parseInt(enttime.substring(6));
                int extsec = Integer.parseInt(exttime.substring(6));

                int ents = (enthour*3600) + (entmin*60) +entsec;
                int exts = (exthour*3600) + (extmin*60) +extsec;

                int times = exts - ents;
                float time = (float)times/3600;
                
                if(time <= 1){
                    return time* Hourch;
                }
                else if(time >= 1 && time <= 4){
                    return (Hourch*(time+1))/2;
                }

                else{
                    return (Hourch*((2*time) + 7))/6;
                }
                }
            }
            
        }
        return 0;
    }
        //method to change exit time of the ustomer by taking TicketNo
    protected void changeextime(int n)
    {   SimpleDateFormat formatter = new SimpleDateFormat("kk:mm:ss");
        Date ExiTime = new Date();
        Transaction d = TransacArray.get(n-1);
        d.Extime = formatter.format(ExiTime.getTime());
    }

}
//-----------------------------------------------------------------------------------------------------------------------------------------------------//

class Captchac {
    //This method is used to generate new captcha code every time at the time of card Payment
    public String generateCaptcha() {
     Random random = new Random();
     int length = 5;
     StringBuffer captchaStringBuffer = new StringBuffer();
     for (int i = 0; i < length; i++) {
      int captchaNumber = Math.abs(random.nextInt()) % 60;
      int charNumber = 0;
      if (captchaNumber < 26) {
       charNumber = 65 + captchaNumber;
      }
      else if (captchaNumber < 52){
       charNumber = 97 + (captchaNumber - 26);
      }
      else {
       charNumber = 48 + (captchaNumber - 52);
      }
      captchaStringBuffer.append((char)charNumber);
     }
    
     return captchaStringBuffer.toString();
    } 
}

//-----------------------------------------------------------------------------------------------------------------------------------------------------//

public class Parking
{   // Here we create different methods for customers to ask what he want to do

    static void PAYPORT()//Method for payment portal menu
    {
        System.out.println("  PAYMENT PORTAL");
        System.out.println("1.ENTER 1 TO PAY IN CASH");
        System.out.println("2.ENTER 2 TO PAY WITH CARD");

    }

    static void Mainmenu()// Method for Main menu
    {   System.out.println();
        System.out.println("  USER-MENU");
        System.out.println();
        System.out.println("1.ENTRY POINT-TICKET");
        System.out.println("2.EXIT POINT");
        System.out.println("3.INFO PORTAL");
        System.out.println("4.ADMIN MENU");
        System.out.println("5.CHARGING STATION");
        System.out.println("6.EXIT");
        System.out.println();
        System.out.println("PLEASE ENTER A NUMBER BASED ON REQUIREMENT: ");
    }

    static void assignspotmenu()// method for Assigning spots menu
    {   System.out.println();
        System.out.println("   ASSIGN SPOT MENU");
        System.out.println();
        System.out.println("1.SYSTEM ASSIGNED SPOT");
        System.out.println("2.SELF ASSIGNED SPOT");
        System.out.println();  
        System.out.println("ENTER THE NUMBER BASED ON REQUIREMENT: ");
    }

    static void AdminMenu()// methods for Admin menu
    {   System.out.println(); 
        System.out.println("  ADMIN-MENU");
        System.out.println(); 
        System.out.println("1.ADD NEW VEHICLETYPE");
        System.out.println("2.ADD NEW PARKING FLOORS/SPOTS");
        System.out.println("3.ADD NEW ENTRY/EXITPOINTS");
        System.out.println("4.REMOVE A VEHICLE TYPE");
        System.out.println("5.REMOVE A PARKING SPOT");
        System.out.println("6.REMOVE A ENTRY/EXIT POINT");
        System.out.println("7.EXIT ADMIN MENU");
        System.out.println(); 
        System.out.println("ENTER THE NUMBER BASED ON REQUIREMENT: "); 
    }

    static void ChargeType()// method for menu at charging point
    {
        System.out.println("   ELECTRIC VEHICLE TYPE");
        System.out.println();
        System.out.println("1.REGULAR CHARGING PORT(150kWh)");
        System.out.println("2.FAST CHARGING PORT(500kWh)");
        System.out.println(); 
        System.out.println("ENTER THE NUMBER BASED ON REQUIREMENT: "); 
    }
    static void infomenu()// method for information menu
    {   System.out.println();
        System.out.println(" INFORMATION PORTAL");
        System.out.println();
        System.out.println("1.PRINT TICKET");
        System.out.println("2.PAY NOW");
        System.out.println(); 
        System.out.println("ENTER THE NUMBER BASED ON REQUIREMENT: "); 
    }

    public static void main(String [] args)
    {   Scanner sc = new Scanner(System.in);
        boolean start=true;
        int k=1;
        checkPointArray cpa =new checkPointArray();//creating object of type checkPointArray
        FloorsArray stp = new FloorsArray();// creating object of type FloorsArray
        ParkTypeArray pkarr = new ParkTypeArray();//creating the object of type ParkTypeArray
        payment obj6 = new payment();//creating the object of type payment
        Mainmenu();

        while(start!=false)
        {   
            int inp = sc.nextInt();
            if(inp==1)
            {   pkarr.displayfunction();
                System.out.println();
                System.out.println("ENTER YOUR VEHICLETYPE ID BASED ON MENU ABOVE: ");
                int inp1 = sc.nextInt();
                assignspotmenu();
                //---------------//
                int apm = sc.nextInt();
                if(apm==1)
                {
                        
                        stp.assignSpot(inp1);
                    
                        if(stp.status1){
                            sc.nextLine();
                            System.out.println();
                            System.out.println("PLEASE ENTER YOUR NAME: ");
                            String nm = sc.nextLine();
                            System.out.println();
                            System.out.println("PLEASE ENTER VEHICLE NUMBER: ");
                            String vnum = sc.nextLine();
                            cpa.entrydisplay();
                            System.out.println();
                            System.out.println("PLEASE ENTER THE ENTRY GATE NUMBER: ");
                            int ennum = sc.nextInt();
                            System.out.println();
                            System.out.println("YOU HAVE SUCCESSFULLY RESERVED YOUR SPOT");
                            System.out.println();
                            int fnum = stp.f;
                            int spotnum = stp.s;
                            obj6.addparktype(nm,vnum,inp1 ,ennum,0,fnum,spotnum,k);
                            k++;
                            obj6.dispbaseonvnum(vnum );
                        }
                        
                   Mainmenu();
                   

                }
                else if(apm==2)
                {   pkarr.utility(inp1);
                    System.out.println();
                    stp.displayall(inp1);
                    System.out.println("CHOOSE A POSITION THAT IS FREE: ");
                    int a = sc.nextInt();
                   
                    stp.SelfAssign(a, inp1);

                    if(stp.status2){
                        sc.nextLine();
                        System.out.println("PLEASE ENTER YOUR NAME: ");
                        String nm = sc.nextLine();
                        System.out.println("PLEASE ENTER VEHICLE NUMBER: ");
                        String vnum = sc.nextLine();
                        cpa.entrydisplay();
                        System.out.println("PLEASE ENTER THE ENTRY GATE NUMBER: ");
                        int ennum = sc.nextInt(); 
                        System.out.println();
                        System.out.println("YOU HAVE SUCCESSFULLY RESERVED YOUR SPOT");
                        System.out.println();
                        int fnum = stp.f;
                        int spotnum = stp.s;
                        obj6.addparktype(nm, vnum, inp1, ennum, 0, fnum, spotnum, k);
                        k++;
                        obj6.dispbaseonvnum(vnum );
                    }   
                   
                    Mainmenu();
                }
                
                
                
            }
            else if(inp==2)
            {   PAYPORT();
                int payinp =sc.nextInt();
                if(payinp == 1)
                {   System.out.println();
                    System.out.println("PLEASE ENTER YOUR TICKETNUMBER TO VERIFY PAYMENT STATUS");
                    int payinp1 =sc.nextInt();
                    int verify=obj6.checker(payinp1);
                    if(verify==0)
                    {   System.out.println();
                        System.out.println("YOUR PAYMENT STATUS IS: UNPAID");
                        System.out.println("WOULD YOU LIKE TO PROCEED TO PAY? : PRESS 'Y' TO PROCEED");
                        char c = sc.next().charAt(0);
                        if(c == 'Y'){
                            obj6.changeextime(payinp1);
                            int p = obj6.returnPType(payinp1);
                            int cha = pkarr.returnCharge(p);
                            float money = obj6.moneycalc(payinp1,cha);
                            System.out.println();
                            System.out.println("THE PARKING FEE IS: "+money);
                            System.out.println("PLEASE PAY YOUR ATTENDANT....");
                            obj6.changePaymentStatus(payinp1);
                            cpa.exitdisplay();
                            System.out.println();
                            System.out.println("PLEASE ENTER THE EXIT YOU WOULD LIKE TO LEAVE IN OUR SYSTEM WILL OPEN IT FOR YOU");
                            int expo =sc.nextInt();
                            obj6.changeexpoint(payinp1,expo);
                            System.out.println(("PAYMENT SUCCESSFUL YOU MAY LEAVE THROUGH YOUR CHOSEN EXIT"));

                        }

                        else{
                            System.out.println("CALLING COPS....");
                        }
                    }
                    else if(verify==1){
                        System.out.println();
                        System.out.println("YOUR PAYMENT HAS BEEN SUCCESFULLY COMPLETED");
    
                    }
                    else if(verify==2)
                    {   System.out.println();
                        System.out.println("INAVLID TICKET NUMBER");
                    }
                }
                else if(payinp==2)
                {
                    System.out.println("PLEASE ENTER YOUR TICKETNUMBER TO VERIFY PAYMENT STATUS");
                    int payinp1 =sc.nextInt();
                    int verify=obj6.checker(payinp1);
                    if(verify==0)
                    {
                        System.out.println("YOUR PAYMENT STATUS IS: UNPAID");
                        System.out.println("WOULD YOU LIKE TO PROCEED TO PAY? : PRESS 'Y' TO PROCEED");
                        char c = sc.next().charAt(0);
                        if(c == 'Y'){
                            obj6.changeextime(payinp1);
                            int p = obj6.returnPType(payinp1);
                            int cha = pkarr.returnCharge(p);
                            float money = obj6.moneycalc(payinp1,cha);
                            System.out.println();
                            System.out.println("THE PARKING FEE IS: "+money);
                            System.out.println();
                            System.out.println("PLEASE ENTER YOUR CARD NUMBER: ");
                            long s = sc.nextLong();
                            sc.nextLine();
                            Captchac cap = new Captchac();
                            String capout = cap.generateCaptcha();
                            System.out.println();
                            System.out.println("PLEASE ENTER THE CAPTCHA: "+capout);
                            String capin = sc.nextLine(); 
                            System.out.println();
                            System.out.println("PAYMENT IN PROGRESS...");
                            if(capin.equals(capout)){
                                obj6.changePaymentStatus(payinp1);
                                System.out.println();
                                System.out.println(("PAYMENT SUCCESSFUL!"));
                                cpa.exitdisplay();
                                System.out.println();
                                System.out.println("PLEASE ENTER THE EXIT YOU WOULD LIKE TO LEAVE IN OUR SYSTEM WILL OPEN IT FOR YOU");
                                int expo =sc.nextInt();
                                obj6.changeexpoint(payinp1,expo);
                                System.out.println(("PAYMENT SUCCESSFUL YOU MAY LEAVE THROUGH YOUR CHOSEN EXIT"));
                            }
                            
                            else{
                                System.out.println("THE CAPTCHA IS WRONG");
                            }
                        }

                        else{
                            System.out.println("CALLING COPS....");
                        }
                    }
                    else if(verify==1){
                        System.out.println();
                        System.out.println("YOUR PAYMENT HAS BEEN SUCCESFULLY COMPLETED");
    
                    }
                    else if(verify==2)
                    {   System.out.println();
                        System.out.println("INAVLID TICKET NUMBER");
                    }

                }
                else
                {
                    System.out.println("SELECTED OPTION NOT PRESENT PLEASE RETRY");
                }
               
               System.out.println();
                    Mainmenu();

            }
            else if(inp==3)
            {   infomenu();
                int l = sc.nextInt();
                if(l==1)
                {
                    System.out.println("ENTER VEHICLE NUMBER");
                    sc.nextLine();
                    String vehnum = sc.nextLine();
                    System.out.println();
                    System.out.println("PRINTING TICKET.......");
                    System.out.println();
                    obj6.dispbaseonvnum(vehnum);


                }
                else if(l==2)
                {
                PAYPORT();
                int payinp =sc.nextInt();
                if(payinp == 1)
                {   System.out.println();
                    System.out.println("PLEASE ENTER YOUR TICKETNUMBER TO VERIFY PAYMENT STATUS");
                    int payinp1 =sc.nextInt();
                    int verify=obj6.checker(payinp1);
                    if(verify==0)
                    {   System.out.println();
                        System.out.println("YOUR PAYMENT STATUS IS: UNPAID");
                        System.out.println("WOULD YOU LIKE TO PROCEED TO PAY? : PRESS 'Y' TO PROCEED");
                        char c = sc.next().charAt(0);
                        if(c == 'Y'){
                            obj6.changeextime(payinp1);
                            int p = obj6.returnPType(payinp1);
                            int cha = pkarr.returnCharge(p);
                            float money = obj6.moneycalc(payinp1,cha);
                            System.out.println();
                            System.out.println("THE PARKING FEE IS: "+money);
                            System.out.println("PLEASE PAY YOUR ATTENDANT....");
                            obj6.changePaymentStatus(payinp1);
                            cpa.exitdisplay();
                            System.out.println();
                            System.out.println("PLEASE ENTER THE EXIT YOU WOULD LIKE TO LEAVE IN OUR SYSTEM WILL OPEN IT FOR YOU");
                            int expo =sc.nextInt();
                            obj6.changeexpoint(payinp1,expo);
                            System.out.println(("PAYMENT SUCCESSFUL YOU MAY LEAVE THROUGH YOUR CHOSEN EXIT"));

                        }

                        else{
                            System.out.println("CALLING COPS....");
                        }
                    }
                    else if(verify==1){
                        System.out.println();
                        System.out.println("YOUR PAYMENT HAS BEEN SUCCESFULLY COMPLETED");
    
                    }
                    else if(verify==2)
                    {   System.out.println();
                        System.out.println("INAVLID TICKET NUMBER");
                    }
                }
                else if(payinp==2)
                {
                    System.out.println("PLEASE ENTER YOUR TICKETNUMBER TO VERIFY PAYMENT STATUS");
                    int payinp1 =sc.nextInt();
                    int verify=obj6.checker(payinp1);
                    if(verify==0)
                    {
                        System.out.println("YOUR PAYMENT STATUS IS: UNPAID");
                        System.out.println("WOULD YOU LIKE TO PROCEED TO PAY? : PRESS 'Y' TO PROCEED");
                        char c = sc.next().charAt(0);
                        if(c == 'Y'){
                            obj6.changeextime(payinp1);
                            int p = obj6.returnPType(payinp1);
                            int cha = pkarr.returnCharge(p);
                            float money = obj6.moneycalc(payinp1,cha);
                            System.out.println("THE PARKING FEE IS: "+money);
                            System.out.println("PLEASE ENTER YOUR CARD NUMBER: ");
                            long s = sc.nextLong();
                            sc.nextLine();
                            Captchac cap = new Captchac();
                            String capout = cap.generateCaptcha();
                            System.out.println("PLEASE ENTER THE CAPTCHA: "+capout);
                            String capin = sc.nextLine(); 
                            System.out.println("PAYMENT IN PROGRESS...");
                            if(capin.equals(capout)){
                                obj6.changePaymentStatus(payinp1);
                                System.out.println(("PAYMENT SUCCESSFUL!"));
                                cpa.exitdisplay();
                                System.out.println();
                                System.out.println("PLEASE ENTER THE EXIT YOU WOULD LIKE TO LEAVE IN OUR SYSTEM WILL OPEN IT FOR YOU");
                                int expo =sc.nextInt();
                                obj6.changeexpoint(payinp1,expo);
                                System.out.println(("PAYMENT SUCCESSFUL YOU MAY LEAVE THROUGH YOUR CHOSEN EXIT"));
                            }
                            
                            else{
                                System.out.println("THE CAPTCHA IS WRONG");
                            }
                        }

                        else{
                            System.out.println("CALLING COPS....");
                        }
                    }
                    else if(verify==1){
                        System.out.println();
                        System.out.println("YOUR PAYMENT HAS BEEN SUCCESFULLY COMPLETED");
    
                    }
                    else if(verify==2)
                    {   System.out.println();
                        System.out.println("INAVLID TICKET NUMBER");
                    }
                }
                else
                {   System.out.println();
                    System.out.println("SELECTED OPTION NOT PRESENT PLEASE RETRY");
                }
               
                }
                else
                {   System.out.println();
                    System.out.println("ENTER VALID INPUT");
                }
               
                    System.out.println();
                    Mainmenu();
                
                
            }
            else if(inp==4)
            {   
                int ranvar=1;
                System.out.println("FOR TA CONVENIENCE PASSWORD IS-'AbArSiVi'");
                System.out.println("ENTER THE ADMIN PASSWORD: ");
                sc.nextLine();
                String pass = sc.nextLine();
                if(pass.equals("AbArSiVi")){
                    ranvar = 1;
                    AdminMenu();
                }
                else{
                    ranvar = 0;
                    Mainmenu();
                }
                while(ranvar!=0) 
                    { 
                    int AN =sc.nextInt();
                    if(AN==1)
                    {   pkarr.displayfunction();
                        System.out.println();
                        System.out.println("ENTER A UNIQUE ID NUMBER NOT PRESENT IN ABOVE MENU");
                        int l =sc.nextInt();
                        System.out.println();
                        System.out.println("ENTER A UNIQUE VEHICLETYPE NOT PRESENT IN ABOVE MENU");
                        sc.nextLine();
                        String m = sc.nextLine();
                        System.out.println();
                        System.out.println("ENTER THE HOURLY CHARGES OF VEHICLETYPE");
                        int n = sc.nextInt();
                        pkarr.addparktype(l,m,n);
                        System.out.println("SUCCESFULLY ADDED");
                        AdminMenu();
                    }
                    else if(AN==2)
                    {   System.out.println();
                        System.out.println("ENTER THE FLOOR NUMBER");
                        int l1 =sc.nextInt(); 
                        System.out.println();
                        System.out.println("ENTER THE NUMBER OF PARKING SPOTS YOU WOULD LIKE TO ADD");
                        int l2 =sc.nextInt();
                        System.out.println();
                        System.out.println("ENTER THE VEHICLETYPEID");
                        int l3 =sc.nextInt();
                        stp.addFloors(l2,l3,l1);
                        System.out.println();
                        System.out.println("TO SEE NEW PARKING SPOTS ENTER Y");
                        sc.nextLine();
                        char l4 =sc.next().charAt(0);
                        if(l4 =='Y')
                        {
                            stp.displayfunction();
                            System.out.println();
                            System.out.println();
                            AdminMenu();
                        }
                        else
                        {
                            AdminMenu();
                        }
                        
                    }
                    else if(AN==3)
                    {   
                        System.out.println();
                        System.out.println("WHICH ONE WOULD YOU LIKE TO ADD:");
                        System.out.println("1.ENTRY POINT");
                        System.out.println("2.EXIT POINT");
                        System.out.println();
                        int l6 =sc.nextInt();
                        if(l6==1)
                        {   cpa.entrydisplay();
                            System.out.println("ENTER A UNIQUE ID ");
                            int l4 =sc.nextInt();
                            System.out.println("ENTER NAME OF ENTRY/EXITPOINT:");
                            sc.nextLine();
                            String l3 =sc.nextLine();
                            cpa.addcheckpoint(l4,l3,l6);
                            cpa.entrydisplay();
                        }
                        else if(l6==2)
                        {
                            cpa.exitdisplay();
                            System.out.println("ENTER A UNIQUE ID NOT PRESENT ABOVE:");
                            int l4 =sc.nextInt();
                            System.out.println("ENTER NAME OF ENTRY/EXITPOINT:");
                            sc.nextLine();
                            String l3 =sc.nextLine();
                            cpa.addcheckpoint(l4,l3,l6);
                            cpa.entrydisplay();
                        }
                        else
                        {
                            System.out.println("PLS ENTER WHATS GIVEN IN MENU");

                        }
                        AdminMenu();
                    }
                    else if(AN==4)
                    {   System.out.println("FROM BELOW MENU CHOOSE THE ID YOU WOULD LIKE TO DELETE");
                        pkarr.displayfunction();
                         System.out.println();
                        System.out.println("ENTER ID HERE:");
                        
                        int l4 =sc.nextInt(); 
                        boolean l5 = pkarr.deleteparktype(l4);
                        if(l5 == true)
                        {
                            System.out.println("ID REMOVED");
                        }
                        else{
                            System.out.println("ID NOT PRESENT");
                        }
                        AdminMenu();
                    }
                    else if(AN==5)
                    {   System.out.println();
                        System.out.println("ENTER THE PARKING SPOT YOU WOULD LIKE TO REMOVE");
                        int l4 =sc.nextInt(); 
                        boolean l5 = stp.removespot(l4);
                        if(l5 == true)
                        {
                            System.out.println("PARKINGSPOT REMOVED");
                        }
                        else{
                            System.out.println("PARKINGSPOT NOT PRESENT");
                        }
                        System.out.println();
                        stp.displayfunction();
                        AdminMenu();
                    }
                    else if(AN==6)
                    {   System.out.println();
                        System.out.println("WHICH ONE WOULD YOU LIKE TO REMOVE:");
                        System.out.println("1.ENTRY POINT");
                        System.out.println("2.EXIT POINT");
                        System.out.println();
                        int l6 =sc.nextInt();
                        if(l6==1)
                        {   cpa.entrydisplay();
                            System.out.println();
                            System.out.println("ENTER THE ID TO BE REMOVED:");
                            int l7 =sc.nextInt();
                            boolean l5 = cpa.removecheckpoint(l7,l6);
                            if(l5 == true)
                            {
                            System.out.println("ID REMOVED NEW LIST DISPLAYED BELOW");
                            cpa.entrydisplay();
                            }
                            else
                            {
                            System.out.println("ID NOT PRESENT");
                            }
                        }
                        else if(l6==2)
                        {
                            cpa.exitdisplay();
                            System.out.println();
                            System.out.println("ENTER THE ID TO BE REMOVED:");
                            int l7 =sc.nextInt();
                            boolean l5 = cpa.removecheckpoint(l7,l6);
                            if(l5 == true)
                            {
                            System.out.println("ID REMOVED NEW LIST DISPLAYED BELOW");
                            cpa.exitdisplay();
                            }
                            else
                            {
                            System.out.println("ID NOT PRESENT");
                            }
                        }
                        else
                        {
                            System.out.println("PLS ENTER WHATS GIVEN IN MENU");

                        }
                        AdminMenu();
                    }
                    else if(AN==7)
                    {
                        ranvar=0;
                        Mainmenu();
                    }

                }
            }

            else if(inp == 5){
                ChargeType();
                int type  = sc.nextInt();
                if(type == 1){
                    System.out.println("PLEASE ENTER THE NUMBER OF HOURS YOU WANT TO CHARGE THE VEHICLE:");
                    float sam = sc.nextFloat();
                    PAYPORT();
                    int test = sc.nextInt();
                    if(test == 1){
                        System.out.println("WOULD YOU LIKE TO PROCEED TO PAY? : PRESS 'Y' TO PROCEED");
                        char c = sc.next().charAt(0);
                        if(c == 'Y'){
                            System.out.println("THE PARKING FEE IS: "+ sam*150);
                            
                            System.out.println("PAY YOUR ATTENDANT...");
                            
                            System.out.println(("PAYMENT SUCCESSFUL!"));
                        }

                        else{
                            System.out.println("CALLING COPS....");
                        }
                    }
                    
                    else if(test == 2){
                        System.out.println("WOULD YOU LIKE TO PROCEED TO PAY? : PRESS 'Y' TO PROCEED");
                        char c = sc.next().charAt(0);
                        if(c == 'Y'){
                            System.out.println("THE CHARGING FEE IS: "+ sam*150);
                            System.out.println("PLEASE ENTER YOUR CARD NUMBER: ");
                            long s = sc.nextLong();
                            sc.nextLine();
                            Captchac cap = new Captchac();
                            String capout = cap.generateCaptcha();
                            System.out.println("PLEASE ENTER THE CAPTCHA: "+capout);
                            String capin = sc.nextLine(); 
                            System.out.println("PAYMENT IN PROGRESS...");
                            if(capin.equals(capout)){
                                System.out.println(("PAYMENT SUCCESSFUL!"));
                            }
                            
                            else{
                                System.out.println("THE CAPTCHA IS WRONG");
                            }
                        }
                    }

                }

                else if(type == 2){
                    System.out.println("PLEASE ENTER THE NUMBER OF HOURS YOU WANT TO CHARGE THE VEHICLE:");
                    float sam = sc.nextFloat();
                    PAYPORT();
                    int test = sc.nextInt();
                    if(test == 1){
                        System.out.println("WOULD YOU LIKE TO PROCEED TO PAY? : PRESS 'Y' TO PROCEED");
                        char c = sc.next().charAt(0);
                        if(c == 'Y'){
                            System.out.println("THE CHARGING FEE IS: "+ sam*500);
                            
                            System.out.println("PAY YOUR ATTENDANT...");
                            
                            System.out.println(("PAYMENT SUCCESSFUL!"));
                        }

                        else{
                            System.out.println("TARNSACTION FAILED TRY AGAIN....");
                        }
                    }
                    
                    else if(test == 2){
                        System.out.println("WOULD YOU LIKE TO PROCEED TO PAY? : PRESS 'Y' TO PROCEED");
                        char c = sc.next().charAt(0);
                        if(c == 'Y'){
                            System.out.println("THE CHARGING FEE IS: "+ sam*500);
                            System.out.println("PLEASE ENTER YOUR CARD NUMBER: ");
                            long s = sc.nextLong();
                            sc.nextLine();
                            Captchac cap = new Captchac();
                            String capout = cap.generateCaptcha();
                            System.out.println("PLEASE ENTER THE CAPTCHA: "+capout);
                            String capin = sc.nextLine(); 
                            System.out.println("PAYMENT IN PROGRESS...");
                            if(capin.equals(capout)){
                                System.out.println(("PAYMENT SUCCESSFUL!"));
                            }
                            
                            else{
                                System.out.println("THE CAPTCHA IS WRONG");
                            }
                        }
                    }
                }
                System.out.println();
                    Mainmenu();
            }

            else if(inp==6)
            {
                start=false;
            }

        }

    }
}
