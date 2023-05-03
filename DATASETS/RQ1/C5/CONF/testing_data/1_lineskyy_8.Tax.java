
import java.util.Scanner;

public class Tax {
    Scanner sc = new Scanner(System.in);
    
    long[] incomeArr = {12000000,46000000,88000000,150000000,300000000,500000000,1000000000};
    long[] taxArr = {6,15,24,35,38,40,42,45};
    long result0 = incomeArr[0];
    long[] result = new long[8];
    long[] tax = new long[6];
    public Tax(){}
    void run(){
        System.out.println("[과세금액 계산 프로그램]");
        System.out.print("연소득을 입력해 주세요.:");
        long income = sc.nextInt();
        for (int i = 0; i < incomeArr.length; i++) {
            if (i==0){
                if (income <= incomeArr[i]) {
                    tax[0] = income / 100 * taxArr[i];
                    System.out.printf("%d * %d%% = %d\n", incomeArr[i], taxArr[i], tax[0]);
                }
            }else if (i==1) {
                if (income > incomeArr[0] && income <= incomeArr[1]) {
                    result[0] = income -incomeArr[i-1]; 
                    tax[0] = result0/100*taxArr[0];
                    tax[1] = result[0]/100*taxArr[i];
                    System.out.printf("%d * %d%% = %d\n", result0, taxArr[0], tax[0]);
                    System.out.printf("%d * %d%% = %d\n",result[0],taxArr[i], tax[1]);
                    System.out.println();
                    System.out.printf("[세율에 의한 세금]:           %d\n", tax[0] + tax[1]);
                    System.out.printf("[누진공제 계산에 의한 세금]:    %d",tax[0] + tax[1]);
                }
            }else if (i==2) {
                if (income > incomeArr[0] && income > incomeArr[1] && income <= incomeArr[2]){
                    result[0] = income -incomeArr[i-1]; 
                    result[1] = (income - result0) - result[0]; 
                    tax[0] = result0/100*taxArr[0];
                    tax[1] = result[1]/100*taxArr[i-1];
                    tax[2] = result[0]/100*taxArr[i];
                    System.out.printf("%d * %2d%% = %d\n",result0, taxArr[0], tax[0]);
                    System.out.printf("%d * %d%% = %d\n", result[1], taxArr[1], tax[1]);
                    System.out.printf("%8d * %d%% = %d\n",result[0],taxArr[2],tax[2]);
                    System.out.println();
                    System.out.printf("[세율에 의한 세금]:           %d\n",tax[0]+tax[1]+tax[2]);
                    System.out.printf("[누진공제 계산에 의한 세금]:    %d",tax[0]+tax[1]+tax[2]);
                }
            }else if (i==3) {
                if (income > incomeArr[2] && income <= incomeArr[3]){
                    tax[0] = result0/100*taxArr[0];
                    result[0] = income -incomeArr[i-1]; 
                    result[1] = (income - result0) - result[0]; 
                    result[2] = result[1]- 34000000;
                    result[3] = result[1]- result[2];
                    tax[0] = result0/100*taxArr[0];
                    tax[1] = result[3]/100*taxArr[1];
                    tax[2] = result[2]/100*taxArr[2];
                    tax[3] = result[0]/100*taxArr[3];
                    System.out.printf("%d * %2d%% = %d\n",result0, taxArr[0], tax[0]);
                    System.out.printf("%d * %d%% = %d\n", result[3], taxArr[1], tax[1]);
                    System.out.printf("%d * %d%% = %d\n", result[2], taxArr[2], tax[2]);
                    System.out.printf("%8d * %d%% = %d\n", result[0], taxArr[3], tax[3]);
                    System.out.println();
                    System.out.printf("[세율에 의한 세금]:           %d\n",tax[0]+tax[1]+tax[2]+tax[3]);
                    System.out.printf("[누진공제 계산에 의한 세금]:    %d",tax[0]+tax[1]+tax[2]+tax[3]);
                }
            }else if (i==4) {
                if (income > incomeArr[3] && income <= incomeArr[4] ){
                    tax[0] = result0/100*taxArr[0];
                    result[0] = income -incomeArr[i-1]; 
                    result[1] = (income - result0) - result[0]; 
                    result[2] = result[1]- 34000000;
                    result[3] = result[1]- result[2];
                    result[4] = result[2] - 62000000;
                    result[5] = result[2] - 42000000;
                    tax[0] = result0/100*taxArr[0];
                    tax[1] = result[3]/100*taxArr[1];
                    tax[2] = result[4]/100*taxArr[2];
                    tax[3] = result[5]/100*taxArr[3];
                    tax[4] = result[0]/100*taxArr[4];
                    System.out.printf("%d * %2d%% = %d\n",result0, taxArr[0], tax[0]);
                    System.out.printf("%d * %d%% = %d\n", result[3], taxArr[1], tax[1]);
                    System.out.printf("%d * %d%% = %d\n", result[4], taxArr[2], tax[2]);
                    System.out.printf("%8d * %d%% = %d\n", result[5], taxArr[3], tax[3]);
                    System.out.printf("%8d * %d%% = %d\n", result[0], taxArr[4], tax[4]);
                    System.out.println();
                    System.out.printf("[세율에 의한 세금]:           %d\n",tax[0]+tax[1]+tax[2]+tax[3]+tax[4]);
                    System.out.printf("[누진공제 계산에 의한 세금]:    %d",tax[0]+tax[1]+tax[2]+tax[3]+tax[4]);
                }
            }else if (i==5) {
                if (income > incomeArr[4] && income <= incomeArr[5] ){
                    tax[0] = result0/100*taxArr[0];
                    result[0] = income -incomeArr[i-1];
                    result[1] = (income - result0) - result[0];
                    result[2] = result[1]- 34000000;
                    result[3] = result[1]- result[2];
                    result[4] = result[1] - 42000000;
                    result[5] = result[1] - result[4];
                    result[6] = result[1] - 62000000;
                    result[7] = result[1] - result[6];
                    tax[0] = result0/100*taxArr[0];
                    tax[1] = result[3]/100*taxArr[1];
                    tax[2] = result[5]/100*taxArr[2];
                    tax[3] = result[7]/100*taxArr[3];
                    tax[4] = result[0]/100*taxArr[4];
                    System.out.printf("%d * %2d%% = %d\n",result0, taxArr[0], tax[0]);
                    System.out.printf("%d * %d%% = %d\n", result[3], taxArr[1], tax[1]);
                    System.out.printf("%d * %d%% = %d\n", result[5], taxArr[2], tax[2]);
                    System.out.printf("%8d * %d%% = %d\n", result[7], taxArr[3], tax[3]);
                    System.out.printf("%8d * %d%% = %d\n", result[0], taxArr[4], tax[4]);
                    System.out.println();
                    System.out.printf("[세율에 의한 세금]:           %d\n",tax[0]+tax[1]+tax[2]+tax[3]+tax[4]);
                    System.out.printf("[누진공제 계산에 의한 세금]:    %d",tax[0]+tax[1]+tax[2]+tax[3]+tax[4]);
                }

            }else if (i==6) {
                if (income > incomeArr[5] && income <= incomeArr[6] ){
                    tax[0] = result0/100*taxArr[0];
                    result[0] = income -incomeArr[i-1];
                    result[1] = (income - result0) - result[0];
                    result[2] = result[1]- 34000000;
                    result[3] = result[1]- result[2];
                    result[4] = result[1] - 42000000;
                    result[5] = result[1] - result[4];
                    result[6] = result[1] - 62000000;
                    result[7] = result[1] - result[6];
                    tax[0] = result0/100*taxArr[0];
                    tax[1] = result[3]/100*taxArr[1];
                    tax[2] = result[5]/100*taxArr[2];
                    tax[3] = result[7]/100*taxArr[3];
                    tax[4] = result[0]/100*taxArr[4];
                    System.out.printf("%d * %2d%% = %d\n",result0, taxArr[0], tax[0]);
                    System.out.printf("%d * %d%% = %d\n", result[3], taxArr[1], tax[1]);
                    System.out.printf("%d * %d%% = %d\n", result[5], taxArr[2], tax[2]);
                    System.out.printf("%8d * %d%% = %d\n", result[7], taxArr[3], tax[3]);
                    System.out.printf("%8d * %d%% = %d\n", result[0], taxArr[4], tax[4]);
                    System.out.println();
                    System.out.printf("[세율에 의한 세금]:           %d\n",tax[0]+tax[1]+tax[2]+tax[3]+tax[4]);
                    System.out.printf("[누진공제 계산에 의한 세금]:    %d",tax[0]+tax[1]+tax[2]+tax[3]+tax[4]);
                }
            }

        }
    }

    public static void main(String[] args) {
        Tax tax = new Tax();
        tax.run();



    }
}
