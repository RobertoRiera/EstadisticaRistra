package estadisticaapplication;
import java.util.*;

public class EstadisticasRistras{
    private Map<String, Integer> m = new HashMap<String, Integer>();
    private Set<Character> s = new HashSet<Character>();

    public EstadisticasRistras() {
    }

    public EstadisticasRistras(String ristra) {
        procesa(ristra);
    }

    public void procesa(String ristra) {
    	for(int k =0; k<ristra.length(); k++){
    		s.add(ristra.charAt(k));
    		
    	}
    	ristra = ristra.trim();
    	String palabra = "";
    	for(int i=0;i<ristra.length();i++){
    		if(Character.isLetter(ristra.charAt(i))){
    			palabra = palabra + ristra.charAt(i);
    		}else if(!palabra.equals("")){
    			if(m.get(palabra)!= null){
    				m.put(palabra, m.get(palabra)+1);
    				palabra = "";
    			}else{
    				m.put(palabra, 1);
    				palabra = "";
    			}
    		}
    	}
    	
    	if(!palabra.equals("")){
    		if(m.get(palabra)!=null){
    			m.put(palabra, m.get(palabra)+1);
    		}else{
    			m.put(palabra, 1);
    		}
    	}

    }

    public int númeroPalabras() {
       return m.size();
    }

    public int númeroCaracteres() {
    	return s.size();
    }

    public int frecuenciaPalabra(String palabra) {
        if(m.get(palabra)!=null){
        	return m.get(palabra);
        }else{
        	return 0;
        }
    }
    
    public List<String> másFrecuentes(int n) {
    	List<frecuencia> l = new ArrayList<frecuencia>();
    	for(String tmp : m.keySet()){
    		l.add(new frecuencia(tmp, m.get(tmp)));
    	}
    	Collections.sort(l);
    	
    	List<String> ordenada = new ArrayList<String>();
    	int k=0;
    	for(frecuencia f : l){
    		if(k==n){
    			break;
    		}
    		ordenada.add(f.clave);
    		k++;
    	}
    	return ordenada;
    }
    
    public class frecuencia implements Comparable<frecuencia>{
    	private String clave;
    	private Integer valor;
    	public frecuencia(String c, Integer v){
    		clave = c;
    		valor = v;
    	}
    	@Override
    	public int compareTo(frecuencia f){
    		if(this.valor == f.valor){
    			return this.clave.compareTo(f.clave);
    		}else{
    			return -this.valor.compareTo(f.valor);
    		}
    	}
    	
    }
}