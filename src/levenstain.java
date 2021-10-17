import java.util.Scanner;

public class levenstain
{

    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите 1ое слово: ");
        String str1 = scanner.nextLine();
        System.out.println("Введите 2ое слово: ");
        String str2 = scanner.nextLine();
        System.out.println(levenstain(str1, str2));
    }

    public static int levenstain(String str1, String str2)
    {

        int len1 = str1.length();
        int len2 = str2.length();

        int[][] matrix = new int[len1+1][len2+1];        // создаем матрицу

        for(int i = 1; i <= len1; i++){
            matrix[i][0] = i;
        }

        for(int j = 1;j <= len2; j++){
            matrix[0][j] = j;
        }

        for(int j=1;j<=len2;j++){
            for(int i=1;i<=len1;i++){
                if(str1.charAt(i-1) == str2.charAt(j-1)){
                    matrix[i][j] = matrix[i-1][j-1];
                }
                    else{
                    matrix[i][j] = Math.min(
                            matrix[i-1][j]+1,
                            Math.min(
                                    matrix[i][j-1]+1,
                                    matrix[i-1][j-1]+1
                            )
                        );
                    }
            }
        }

        return matrix[len1][len2];
    }

}
