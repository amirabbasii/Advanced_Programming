import java.util.*;
/**
 * Project 1
 * @author Amir Abbasi
 * FTSYS
 * 
 *
 */
public class ConvertView {
	// list[x] ~ listadad[x]
	static String[] list = { "Sefr", "Yek", "Do", "Seh", "Chahar", "Panj", "Shesh", "Haft", "Hasht", "Noh", "Dah",
			"Yazdah", "Davazdah", "Sizdah", "Chahardah", "Panzdah", "Shanzdah", "Hefdah", "Hejdah", "Noozdah", "Bist",
			"Si", "Chehel", "Panjah", "Shast", "Haftad", "Hashtad", "Navad", "Sad", "Divist", "Sisad", "Chaharsad",
			"Pansad", "Sheshsad", "Haftsad", "Hashtsad", "Nohsad", "Hezar", "Million", "Milliard", "end"};
	static int[] listAdad = { 0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20, 30, 40, 50, 60,
			70, 80, 90, 100, 200, 300, 400, 500, 600, 700, 800, 900, 1000, 1000000, 1000000000, 0,};
	static String [] listMomayez= {"Dahom","Sadom","Hezarom"};

	public static void main(String[] args) {
		int bit;// vordoudi avalie;0 ya 1
		Scanner input = new Scanner(System.in);
		System.out.println("Baraye tabdile Horuf be Raqam 1 va baraye tabdile Raqam be Horuf 0 ra vared konid:");
		bit = input.nextInt();
		String adad;// motagheyere marboot be voroodi adadi ya horufi karbar.
		if (bit == 0) {
			System.out.println("adad ra vared konid:(baraye ashari az / estefade konid:");
adad = input.next();
			/**
			 * adad be beHoruf() ferestade mishavad va javab be halate String barmigardad va chap mishavad
			 */
			System.out.print(beHoruf(adad));} 
		else {
			System.out.println("adad ra vared konid:(baraye ashari az kalame momayez va Dahom,Sadom,Hezarom estefade konid:");
			input.nextLine();// baraye pareshe pointere nextLine() be khate dovom.
			adad = input.nextLine();
			System.out.print(beRaqam(adad));
		}
		input.close();
		}
	/**
	 * @param voroodi be String
	 * @return Javab be String
	 *
	 * beRaqam(String adad):adad ra az horoof be raqam tabdil mikonad.in tabe "adad"
	 * ra be soorat zir dar nazar migirad:(numbers:0-999)
	 * adad=[numbers Milliard] o [numbers Million] o [numbers Million] o [numbers Hezar] o [numbers] end [momayez numbers end]
	 * algoritm:in tabe kalamate beine do "o" ra be onvan adad dar nazar migirad.
	 * migirad.
	 */
	static String beRaqam(String adad) {
		
		int i, j;
		long answer = 0L;// Javab
		String tmp[];// temp baray split
		String momayez;// gesmat ashari adad
		boolean flag;// flage makhsoose ashari boodan ya naboodan adad.agar ashari bashad true mishavad vagarana false.
		if (adad.indexOf(" momayez ") != -1) {
			/*
			 * check mishavad ke adad ghesmat ashari darad ya na
			 * 
			 */
			flag = true;
			tmp = adad.split(" momayez ");
			adad = tmp[0] + " o end";//baraye rafe buge halathaye khas
			momayez = tmp[1];} 
		else {
			/*
			 * agar adad ghesmat ashari nadashte bashad be enteheye adad " o end" zafe
			 * mishavad va flag false va momayez null mishavad.
			 */
			adad += " o end";
			flag = false;
			momayez = null;
		}
		if (adad.indexOf("Milliard") != -1) {
			/*
			 * agar "Milliard daroone adad bashad adad ra bar hasbe "Milliard o " split
			 * mikonad va dakhele tmp[] mirizad.tmp[0] ghesmate milliardi ast ke ke khod bar
			 * hasbe " o " split mishavad va daroone temp[] rikhate mishavad.
			 */
			tmp = adad.split(" Milliard o ");// ghesmate milliardi
			String temp[] = tmp[0].split(" o ");// ghesmathaye split shode tmp
			for (i = 0; i < temp.length; i++) {
				for (j = 0; j < 37; j++) {
					if (temp[i].equals(list[j]) == true) {
						answer += 1000000000L * listAdad[j];//agar baksh dar list[] bashad adad motenazerash ba zarib milliard be javab ezafe mishavad 
						break;
}}
				if (j == 37)// agar j==37 yani deraye peyda nashode va voroodi ghalat ast.		
					return "Invalid input!";
			}
			adad = tmp[tmp.length - 1];// hazfe ghesmate milliardi az adad
										}
		if (adad.indexOf("Million") != -1) {//ghesmate millioni
			tmp = adad.split(" Million o ");
			String temp[] = tmp[0].split(" o ");
			for (i = 0; i < temp.length; i++) {
				for (j = 0; j < 41; j++) {
					if (temp[i].equals(list[j]) == true) {
						answer += 1000000 * listAdad[j];//agar baksh dar list[] bashad adad motenazerash ba zarib millioni be javab ezafe mishavad 
						break;
}}
				if (j == 41)// agar j==37 yani deraye peyda nashode va voroodi ghalat ast.
					return "Invalid input!";
			}
			adad = tmp[tmp.length - 1];//hazfe ghesmate millioni az adad
		}
		if (adad.indexOf("Hezar") != -1) {//ghesmate hezari
			if(adad.indexOf("Hezar")==0)//estesna baraye Hezar-->Yek Hezar
				adad="Yek "+adad;
			tmp = adad.split(" Hezar o ");
			String temp[] = tmp[0].split(" o ");
			for (i = 0; i < temp.length; i++) {
				for (j = 0; j < 41; j++) {
					if (temp[i].equals(list[j]) == true) {
						answer += 1000 * listAdad[j];
						break;}}
				if (j == 41)
					return "Invalid input!";
			}
			adad = tmp[tmp.length - 1];
		}
		tmp = adad.split(" o ");// hala adad beyene 0 ta 999 ast.pas berahati split mishavad.
		for (i = 0; i < tmp.length; i++) {
			for (j = 0; j < 41; j++) {
				if (tmp[i].equals(list[j]) == true) {
					answer += listAdad[j];//kalame motenazere adad be javab ezafe mishavad
					break;
				}}
			if (j == 41)
				return "Invalid input!";
		}
		if (flag == true) {// mohasebe ghesmat ashari
			int tmpAnswer = 0,count=0;// tmp:moteghaye movaghat baraye negahdari ghesmate ashari mohasebe shode   ;count:toole ghesmate ashari
			tmp = momayez.split(" o ");// tafkik be adad mostaghel
			String [] temp=tmp[tmp.length-1].split(" ");//hazfe kalame Dahom ya Sadom ya Hezarom az ghesmat ashari
			tmp[tmp.length-1]=temp[0];//hazfe kalame Dahom ya Sadom ya Hezarom az ghesmat ashari
			for(i=0;i<3;i++) {
				if(temp[temp.length-1].equals(listMomayez[i])==true)//tashkhise kalame ashari(Dahom,Sadom,Hezarom) va tanazor ba toole an
				{count=i+1;//toole ghesmat ashari
					break;
				}}
			if(i==3)
				return "Invalid input!";
			String zeros="";//baraye sakhtane tedad sefr haye morede niaz
			for (i = 0; i < tmp.length; i++) {//mohasebe ghesmate ashari
				for (j = 0; j < 41; j++) {
if (tmp[i].equals(list[j]) == true) {
						tmpAnswer += listAdad[j];
						count=count-String.valueOf(listAdad[j]).length();//kam kardae toole adad az toole ghesamte ashari
						break;
					}}
				if (j == 41)
					return "Invalid input!";
	}
			for(i=1;i<=count;i++)
				zeros+="0";//sakhatane sefr haye mored niaz
			return String.valueOf(answer) + "/"+zeros + String.valueOf(tmpAnswer);// answer,tmpAnswer-->String ;sepas pasokh ba "/" be shekle yek adad ashari return mishavad															
		} else
			return String.valueOf(answer);// answer faghat be "String" tabdli mishavad va return mishavad
}
	/**
	 * @param voroodi be String
	 * @return Javab be String
	 * beHoruf(String adad):adad ra az halat horoof be raqam tabdil mikonad.in tabe
	 * adad ra be soorat zir mishenasad: adad=number[/number]
	 * 
	 */
	static String beHoruf(String adad) {
	
		int i, t = 1, j, momayez,lenthOfMomayez=0;// t nooei moteghayere temp va shomarande ast dar ghesmate rikhtan dar javab.
		boolean flag;// flage makhsoose ashari boodan ya naboodane adad.agar
		long tmp, num;// tmp motaghayere temp ast va num javab adad besoorat int(long)
		String ans[];// temp ast
		if (adad.indexOf("/") == -1) {
			// agar "/" dar adad nabashad yani adad sahih ast va mostaghiman be int tabdil
			// mishavad va dar num rikhte mishavad.
			num = Long.parseLong(adad);
			flag = false;
			momayez = 0;} 
		else {
			// agar ashari dasht bar hasb an split mishavad va dar ans[] rikhte mishavad.va
			// ans[0] ke ghesmat sahih ast dar num va ans[1] ke ghesmat ashari ast dar
			// momayez rikhte mishavad.
			ans = adad.split("/");
			num = Long.parseLong(ans[0]);
			flag = true;
			lenthOfMomayez=ans[1].length();//toole momayez
			momayez = Integer.parseInt(ans[1]);
		}
		String answer = "";
		for (i = 39; i > 36; i--) {
	 //halete estesna baraye milliard,million va hezar:zarib haye milliardi va million va hezari hesab mishavand
			if (num / listAdad[i] >= 1) {
				tmp = num / listAdad[i];// zaribe milliardi ya million ya hezar
				for (j = 36; j > 0; j--) {
					// tabdil tmp az adadi be horufi
					if (tmp / listAdad[j] >= 1) {
						if (answer == "")//halate khas baraye bare aval
							answer = answer + list[j];//adad motenazer kalame be javab ezafe mishavad
						else
							answer = answer + " o " + list[j];//adad motenazer kalame be javab ezafe mishavad
						tmp = tmp % listAdad[j];// tmp shkaste mishavad va adadi ke dar an peyda shode hazf mishavad.
					}}
				if(answer.equals("Yek") && i==37)//estesnaye halate hezar
					answer="Hezar";
				else
				answer = answer + " " + list[i];// kalame zarib be javab ezafe mishavad(Milliard,Million,Hezar)
				num = num % listAdad[i];// num ham shekaste mishavad va ghesamte milliardi ya millioni ya hezari az an hazf mishavad
				}}
		for (i = 36; i >= 1; i--) {
			//mohasebe baraye se raghami be payin
			if (num / listAdad[i] >= 1) {
				if (answer == "")//halate khas baraye bare aval
					answer = answer + list[i];//adad motenazer kalame be javab ezafe mishavad
				else
					answer = answer + " o " + list[i];//adad motenazer kalame be javab ezafe mishavad
				num = num % listAdad[i];}}
		if (flag == true) {
		//peydra kardane ghesmate ashari
			t = 1;
			answer += " momayez ";//kalame momayez be javab ezafe mishavad							
			for (i = 36; i >= 1; i--) {
				if (momayez / listAdad[i] >= 1) {
					if (t == 1) {//halate estesnaye bare aval
						answer += list[i];//adad motenazer kalame be javab ezafe mishavad
						momayez = momayez % listAdad[i];
						t=0;
					} else {
						answer += " o " + list[i];//adad motenazer kalame be javab ezafe mishavad
						momayez = momayez % listAdad[i];}}}
			
answer+=" "+listMomayez[lenthOfMomayez-1];//kalame (dahom,sadom,hezarom) be javab ezafe mishavad
		}
		return answer;
	}

}
