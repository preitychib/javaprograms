import java.util.Scanner;

public class ParagraphDemo {
    public static void main(String[] args) {
        System.out.println("Enter a paragraph");
        Scanner sc = new Scanner(System.in);
        String para = sc.nextLine();
        Paragraph p = new Paragraph(para);
        p.countInPara();
        p.makeInSentenceCase();
        System.out.println("The paragraph is:");
        System.out.println(p);
        System.out.println("The paragraph in reverse order of the words of every line");
        System.out.println(p.reverseParaOrder());
        System.out.println("The paragraph in reverse order of characters");
        System.out.println(p.reversePara());
        sc.close();
    }
}
