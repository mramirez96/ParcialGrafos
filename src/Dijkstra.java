import java.util.ArrayList;
import java.util.Iterator;

public class Dijkstra {

	private GrafoPonderado g;
	int [] prev;
	int [] cost;

	
	public Dijkstra(GrafoPonderado g) {
		this.g = g;
		prev = new int[g.getSize()];
		cost = new int[g.getSize()];
	}
	
	
	public void run(int nodo){
		int evalNode = nodo;
		
		int cMin = -1;
		int nMin=-1;
		
		prev[evalNode]=-1;
		cost[evalNode]=0;
		ArrayList<Integer> setted= new ArrayList<>(); //arrays con costo no definitivo
		setted.add(evalNode);
		
		while(evalNode!=-1){ // hay nodo para evaluar
			System.out.println(evalNode+"(p:"+prev[evalNode]+")"+"-c:"+cost[evalNode]);
			setted.remove(setted.indexOf(evalNode)); //elimina el nodo fijado
			for(int i=0;i<g.getSize();i++){
				int dist = g.costo(evalNode, i); //distancia al origen
	
				if(dist > -1){
					dist+=cost[evalNode];
					if(dist < cost[i] || cost[i]==0){ // este costo es menor al previo
						prev[i]=evalNode;
						cost[i]=dist;
						setted.add(i);
					}
				}
			}
			
			//busca nodo minimo entre los pendientes a fijar
			Iterator<Integer> it = setted.iterator();
			while(it.hasNext()){
				int n = it.next();
				if(cMin == -1 || cost[n] < cMin ){
					nMin=n;
					cMin = cost[n];
				}
			}
			evalNode = nMin;
			cMin = -1;
			nMin= -1;
		}
	}
}
