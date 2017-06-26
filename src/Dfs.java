import java.util.ArrayList;
import java.util.Stack;

import javax.crypto.CipherSpi;

import grafos.GrafoNDNP;

public class Dfs {
	private GrafoNDNP g;
	private Stack<Integer> s;
	
	public Dfs(GrafoNDNP g) {
		this.g= g.clone();
	}
	
	public void run(int nodo){
		s = new Stack<>();
		ArrayList<Integer> visited = new ArrayList<>(); // visitados
		boolean found;
		int el;
		s.push(nodo);
		visited.add(nodo);
		System.out.println((nodo+1));
		while(!s.isEmpty()){
			found = false;
			el = s.peek();
			for (int i =0; found==false && i<g.getSize();i++){
				if(el!=i && !visited.contains(i) && g.estaConectado(el, i)){
					found = true;
					s.push(i);
					visited.add(i);
					System.out.println((i+1));
				}
			}
			if(!found)
				s.pop();
		}
	}
}
