package usuarios;

class encrypt {
	
	public static String encriptar(String linea){
		
	    char array[]=linea.toCharArray(); 
	     
	    for(int i=0;i<array.length;i++){ 
	    		array[i]=(char)(array[i]+(char)5); 
	    } 
	    String encriptado =String.valueOf(array);
	    
		return encriptado;
	}
	
	public static String desencriptar(String lineaEncriptada) {
		
		char arrayD[]=lineaEncriptada.toCharArray(); 
        for(int i=0;i<arrayD.length;i++){ 
            arrayD[i]=(char)(arrayD[i]-(char)5); 
        } 
        
        String desencriptado =String.valueOf(arrayD); 
        
        return desencriptado;
		
	}
}
