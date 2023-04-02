#include <stdio.h>
#include <stdlib.h>
#include <unistd.h>

//0 => proceso hijo
//!=1 => proceso padre

int main(){

	for(int i=0; i < 3; i++){
		
		if(fork()==0) {
      
			if(i==1){
        
				for(int j=0; j < 2; j++){
          
					if(fork()==0){
            
						if(j == 1){
              
							for(int k=0; k < 2; k++){
                
								if(fork() != 0){
									break;
								}
							}
						}
						break;
					}
				}
			}
			break;
		}
	}
}
