/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package change.pkg2.pkg10.pkg16;

/**
 *
 * @author Thanh Hang
 */
public class BaseConverter {

    public static int display(String from, String case1, String case2) {
        System.out.println("1. Convert from " + from + "to " + case1);
        System.out.println("2. Convert from " + from + "to " + case2);
        int choice = Validation.inputInteger("Enter your choice: ", 1, 2);
        return choice;
    }
    public static void convertFromBinary(String binary){
        int choice = display("binary","decimal","hexadecimal");
        switch(choice){
            case 1:
                System.out.println("Decimal: "+ binToDec(binary));
                break;
            case 2:
                System.out.println("Hexadecimal: "+ binToHex(binary));
        }
    } 
    public static void convertFromDecimal(String decimal){
        int choice = display("decimal", "binary", "hexadecimal");
        switch(choice){
            case 1:
                System.out.println("Binary: "+ decToBin(decimal));
                break;
            case 2:
                System.out.println("Hexadecimal: "+ decToHex(decimal));
        }
    }
    public static void convertFromHex(String decimal){
        int choice = display("hexa", "binary", "decimal");
        switch(choice){
            case 1:
                System.out.println("Binary: "+ hexToBin(decimal));
                break;
            case 2:
                System.out.println("Decimal: "+ hexToDec(decimal));
        }
    }

    public static String binToDec(String binary) {
        int decimal = 0;
        int power = 1;
        
        for (int i = binary.length() - 1; i >= 0; i--) {
            char bit = binary.charAt(i);
            decimal += (bit - '0') * power;
            power *= 2;
        }
        return String.valueOf(decimal);
    }

    public static String decToBin(String decimal) {
        int dec = Integer.parseInt(decimal);
        if(dec==0) return "0";
        StringBuilder sb = new StringBuilder();
        while(dec>0){
            sb.insert(0, dec%2);
            dec/=2;
        }
        return sb.toString();
    }

// ===== Hex <-> Decimal =====
    public static String hexToDec(String hex) {
        hex = hex.toUpperCase();
        int decimal=0;
        int power=1;
        for(int i=hex.length()-1;i>=0;i--){
            char c = hex.charAt(i);
            if(c>='0'&&c<='9') decimal+=c*power;
            if(c>='A'&&c<='F') decimal+=(c-'A'+10)*power;
            power*=16;
        }
         return String.valueOf(decimal);
        
    }

    public static String decToHex(String decimal) {
        int dec = Integer.parseInt(decimal);
        if(dec==0) return "0";
        StringBuilder sb = new StringBuilder();
        while(dec>0){
            int c = dec%16;
            char hex;
            if(c<10) hex = (char) ('0'+c);
            else hex = (char)('A'+c-10);
            sb.insert(0, hex);
            dec/=16;
        }
        return sb.toString();
    }

// ===== Binary <-> Hex =====
// Ý tưởng: đổi qua decimal làm trung gian cho dễ
    public static String binToHex(String binary) {
        return decToHex(binToDec(binary));
    }

    public static String hexToBin(String hex) {
        return decToBin(hexToDec(hex));
    }
 // public static String decToBin(String decimal) {
//        int n = Integer.parseInt(decimal);
//        if (n == 0) return "0";
//        if (n == 1) return "1";
//        return decToBin(String.valueOf(n / 2)) + (n % 2);
//    }
//
//    // ===== Decimal -> Hex =====
//    public static String decToHex(String decimal) {
//        int n = Integer.parseInt(decimal);
//        if (n == 0) return "0";

//    if (n < 16) {
//        return (n < 10) ? String.valueOf(n) : String.valueOf((char) ('A' + (n - 10)));
//    }
//
//    return decToHex(n / 16) + 
//           ((n % 16 < 10) ? String.valueOf(n % 16) 
//                          : String.valueOf((char) ('A' + (n % 16))));
//    }
//    // ===== Binary -> Decimal =====
//    public static String binToDec(String binary) {
//        if (binary.length() == 0) return "0";
//        if (binary.length() == 1) return binary; // chỉ còn 1 bit
//        int firstBit = binary.charAt(0) - '0';
//        int power = (int) Math.pow(2, binary.length() - 1);
//        return String.valueOf(firstBit * power + Integer.parseInt(binToDec(binary.substring(1))));
//    }
//     public static String hexToDec(String hex) {
//     // base case: chuỗi rỗng => 0
//     if (hex.length() == 0) return "0";
//     // base case: còn 1 ký tự => trả về giá trị số
//     if (hex.length() == 1) {
//         char c = hex.charAt(0);
//         if (c >= '0' && c <= '9') return String.valueOf(c - '0');
//         else return String.valueOf(c - 'A' + 10);
//     }
//     // xử lý ký tự đầu
//     char first = hex.charAt(0);
//     int firstVal = (first >= '0' && first <= '9') ? (first - '0') : (first - 'A' + 10);
//     int power = (int) Math.pow(16, hex.length() - 1);

//     // công thức: giá trị = val(ký tự đầu) * 16^(n-1) + giá trị(đệ quy phần còn lại)
//     return String.valueOf(firstVal * power + Integer.parseInt(hexToDec(hex.substring(1))));
// }
}


