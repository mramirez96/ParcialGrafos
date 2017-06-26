
import java.util.ArrayDeque;
import java.util.ArrayList;

import grafos.GrafoNDNP;

public class Bfs {

	private GrafoNDNP g;
	private ArrayDeque<Integer> q;
	
	public Bfs(GrafoNDNP g){
		this.g= g.clone();
	}
	
	public void run(int nodo){
		ArrayList<Integer> visited = new ArrayList<>(); // visitados
		
		int dist = 0; // distancia al nodo
		q = new ArrayDeque<>();
		
		q.add(nodo);
		visited.add(q.peek());
		System.out.println(q.peek()+1);
		q.add(-1); // -1 indica cambio de distancia al nodo origen
		
		while(!q.isEmpty() && q.peek()!=-1){
			for(int i=0; i< g.getSize();i++){
				if(		i!=q.peek() && 
						g.estaConectado(q.peek(), i) &&
						!visited.contains(i)){
					
					visited.add(i);
					q.offer(i);
					// dist+1 porque estan a una arista de la distancia actual
					// i+1 para verlo bien con el graficador
					System.out.println((i+1)+" d:"+(dist+1)); 
					
				}
			}
			
			q.remove();
			
			if(q.peek()==-1){ // si hay un menos uno incrementar la distancia
				dist++;
				q.offer(q.remove()); // saca el -1 y lo pone al final
			}
		}
	}
	
	
}
