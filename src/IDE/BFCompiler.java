package IDE;

import java.util.Arrays;

/**
 * Created by wenxi on 2017/5/4.
 */
public class BFCompiler {

    String input;
    String code;
    char[] inputs;
    char[] codes;
    int inputPointer;
    int pointer;//指针

    char[] memory=new char[1000];//内存

    StringBuilder ouputBuilder=new StringBuilder();

    /*
    @param code 代码
    @param input 输入数据
     */
    public BFCompiler(String code, String input){
        this.code = code;
        this.input = input;
        codes=this.code.toCharArray();
        inputs = this.input.toCharArray();

        Arrays.fill(memory,(char)0);

        pointer=0;
        inputPointer=0;
    }


    /*
    @return 输出的数据
     */
    public String compile(int index){
        for(int i=index;i<codes.length;i++){
            switch (codes[i]){
                case '>':
                    this.pointer++;
                    //System.out.println("pointer:"+this.pointer);
                    break;
                case '<':
                    this.pointer--;
                    //System.out.println("pointer:"+this.pointer);
                    break;
                case '+':
                    memory[this.pointer]++;
                    //System.out.println("memory["+this.pointer+"]："+(int)memory[this.pointer]);
                    break;
                case '-':
                    memory[this.pointer]--;
                    //System.out.println("memory["+this.pointer+"]："+(int)memory[this.pointer]);
                    break;
                case '.':
                    ouputBuilder.append(memory[this.pointer]);
                    //System.out.print(memory[this.pointer]);break;
                case ',':
                    if(inputs.length!=0){
                        memory[this.pointer]=inputs[inputPointer];
                        inputPointer++;
                    }
                    break;
                case '[':
                    int tempPointer=this.pointer;
                    //找出循环结束的位置
                    int endLoop=i+1;
                    int leftCount=1;//左括号的数量，可能出现内循环
                    for(int j=i+1;j<codes.length;j++){
                        if(codes[j]=='[') leftCount++;
                        if(codes[j]==']'){
                            leftCount--;
                            if(leftCount==0){
                                endLoop=j;
                                break;
                            }
                        }
                    }
                    while (memory[tempPointer]!='\0'){
                        //System.out.println("index:"+i);
                        compile(i+1);//编译 从[后的代码
                        //System.out.println((int)memory[tempPointer]);
                    }
                    //System.out.println("loop end");
                    i=endLoop;//将代码的读取位置移到]的下一位
                    break;
                case ']':
                    //System.out.println("return");
                    return "";
            }
        }
        return ouputBuilder.toString();
    }

    public static void main(String[] args) {
        BFCompiler BFCompiler =new BFCompiler("++++[>++++[>+++<-]<-]>>.","");
        String a= BFCompiler.compile(0);
        System.out.println(a);
    }
}
