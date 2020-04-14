package Tool;



import java.io.IOException;
import java.util.ArrayList;
import java.util.Random;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import GameData.Dot;
import it.unical.mat.embasp.languages.asp.AnswerSets;

public class AnswerSetManager {

	AnswerSets answer;
	
	public AnswerSetManager(AnswerSets answer) {
		this.answer=answer;
	}
	
	
	public Dot[] giveMeAnswer() throws IOException {
		String el1= answer.getAnswerSetsString();
		String[]el2 = el1.split("\\.");
		ArrayList<String> el3= new ArrayList<String>();
			for(int i=0; i<el2.length; i++) {
				if(el2[i].contains("new") && !el2[i].contains("nonlinea")) {
					el3.add(el2[i]);
				}
			}
		Random rand=new Random();
		int n=rand.nextInt(el3.size());
		Pattern p = Pattern.compile("\\d+");
        Matcher m = p.matcher(el3.get(n));
        ArrayList<Integer> digit= new ArrayList<Integer>() ;
        while(m.find()) {
           digit.add(Integer.parseInt(m.group()));
        }
        
        Dot [] output= new Dot[2];
        output[0]=new Dot(digit.get(0), digit.get(1));
        output[1]=new Dot(digit.get(2), digit.get(3));
        return output;
	}
}
