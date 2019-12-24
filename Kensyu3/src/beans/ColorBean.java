package beans;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class ColorBean implements Serializable{
	private static final long serialVersionUID = 1L;

	private List<String> dark = new ArrayList<String>();
	private List<String> light = new ArrayList<String>();

	public ColorBean(){
		dark.add("#e60033");  //a
		dark.add("#0095d9");  //b
		light.add("#ffd900"); //c
		dark.add("#884898");  //d
		dark.add("#2b2b2b");  //e
		light.add("#ffd900"); //f
		dark.add("#3eb370");  //g
		dark.add("#ee7800");  //h
		dark.add("#674196");  //i
		dark.add("#7d7d7d");  //j
		light.add("#fef4f4"); //k
		light.add("#b8d200");  //l
		dark.add("#f0908d");  //m
		dark.add("#38b48b");  //n
		light.add("#bce2e8");  //o
		dark.add("#00a3af");  //p
		dark.add("#eb6101");  //q
		dark.add("#68be8d");  //r
		dark.add("#96514d");  //s
		light.add("#eebbcb");  //t
		dark.add("#7058a3");  //u
		dark.add("#762f07");  //v
		dark.add("#c38743");  //w
		dark.add("#b7282e");  //x
		dark.add("#1e50a2");  //y
		light.add("#c5c56a");  //z

		light.add("");
	}

	public List<String> getDark() {
		return dark;
	}

	public void setDark(List<String> dark) {
		this.dark = dark;
	}

	public List<String> getLight() {
		return light;
	}

	public void setLight(List<String> light) {
		this.light = light;
	}
}
