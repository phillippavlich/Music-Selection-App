import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

//python error import ouac thing

public class computeSimilarSongs extends WindowsBuilderPractice {
	
	public computeSimilarSongs(List<Song> DATA) {
		super(DATA);
		// TODO Auto-generated constructor stub
	}

	protected static List<Song> data;
	
	//used to calculate the data from the array
	//used to search data set for a similar song
	
	public static void test(List<Song> data1){
		data=data1;
	
		//ASSUME FOR NOW FIRST SONG PLAYED IS INDEX 0
		ArrayList<Integer> intAL = new ArrayList<Integer>();
		ArrayList<String> stringAL = new ArrayList<String>();

		String[] stringArr = {"Artist", "Tempo", "Loudness", "Dance", "Hotness"};
		int[] valueOrder = {2, -2, 1, -1, 0, -3};
	
		sortArray(questionResponses, stringArr, valueOrder, intAL, stringAL);
	
		for(int i = 0; i < 5; i++){
			questionResponses[i]=intAL.get(i);
			stringArr[i]=stringAL.get(i);
		}
		
		
		
		for(int I = 0; I < 5; I++){
			start(questionResponses[I],stringArr[I],data.get(0));
		}
		System.out.println(data.size());
		
		
		if(data.size()>378){
			data.remove(0);
			boolean val=MusicPlayer.getMP3(data.get(0).getTrack_7digitalid());
			System.out.println(val);
			MusicPlayer newPlayer1 = new MusicPlayer(data.get(0));
			
			newPlayer1.addExitListener(new ActionListener(){
				@Override
				public void actionPerformed(ActionEvent e){
					WindowsBuilderPractice run=new WindowsBuilderPractice(data);
					run.QA(data);
				}
			});
		}
		else{
			data.remove(0);
			System.out.println(data.get(0).getArtist_name());
			System.out.println(data.get(0).getTitle());
			System.out.println(data.get(0).getArtist_7digitalid());
			System.out.println(data.get(0).getTrack_7digitalid());
			System.out.println(" ");
		}
		
		
		///////////////// THIS IS WHERE IT BECOMES RECURSIVE, CALL ON PLAY SONG WITH THE FIRST INDEX OF data, CALL ON QUESTION METHOD
		
	}
	
	public static List<Song> allSongs(){
		List<Song> ret = new ArrayList<Song>();
		try(BufferedReader br = new BufferedReader(new FileReader(new File( "MSD.csv" )))) {
		    for(String line; (line = br.readLine()) != null; ) {
		        ret.add(new Song(line));
		    }
		} catch (IOException e) {
		
			e.printStackTrace();
		}
		
		//ret.remove(0);
		return ret;
	}

	public static void sortArray(int[] intArray, String[] stringArray, int[] value, ArrayList<Integer> intAL, ArrayList<String> stringAL){
		
		for(int index = 0; index < 6; index++){
			for(int id2 = 0; id2 < 5; id2++ ){
				if(intArray[id2]==value[index]){
					intAL.add(intArray[id2]);
					stringAL.add(stringArray[id2]);
				}
			}
			
		}
		
	}
	
	private static void start(int value,String index,Song file){
		if(index.equals("Artist")){
		
			if(data.size()>20){
				artist(value,file);
			}
		}
		else if(index.equals("Tempo")){
			
			if(data.size()>20){
				tempo(value,file);
			}
		}
		else if(index.equals("Loudness")){
			
			if(data.size()>20){
				loudness(value,file);
			}
		}
		else if(index.equals("Hotness")){
			
			if(data.size()>20){
				songHot(value,file);
			}
		}
		else{
			
			if(data.size()>20){
				danceability(value,file);
			}
		}
		
	}
	
	
	private static void artist(int value,Song file) {
		
		List<Song> temp=new ArrayList<Song>();
		switch (value){
		case 2:
			try{
				
				String[] temporary=file.getSimilar_artists();
				if(temporary!=null){
					for(int b=0;b<temporary.length;b++){
						for(int a=0;a<data.size();a++){
							if(temporary[b].equals(data.get(a).getArtist_id()) && !temp.contains(data.get(a))){
								temp.add(data.get(a));
							}
						}
					}
					
					//data=new ArrayList<Song>();
					//data=temp;
					
				
				
					
				}
			}
			catch(Exception e){
				System.out.println("error");
				e.printStackTrace();
			}
			break;
			
		case -2:
			try{
				
				String[] temporary=file.getSimilar_artists();
				if(temporary!=null){
					for(int b=0;b<temporary.length;b++){
						for(int a=0;a<data.size();a++){
							if(temporary[b].equals(data.get(a).getArtist_id()) && !temp.contains(data.get(a))){
								temp.add(data.get(a));
							}
						}
					}
				
					
					for(int index = 0; index< temp.size(); index++){
						data.remove(temp.get(index));
					}
					
				
				
					
				}
			}
			catch(Exception e){
				System.out.println("error");
				e.printStackTrace();
			}
			break;
		
		case 1:
			try{
				
				String[] temporary=file.getSimilar_artists();
				if(temporary!=null){
					for(int b=0;b<temporary.length;b++){
						for(int a=0;a<data.size();a++){
							if(temporary[b].equals(data.get(a).getArtist_id()) && !temp.contains(data.get(a))){
								temp.add(data.get(a));
							}
						}
					}
					
					//data=new ArrayList<Song>();
					//data=temp;
					
				
				
					
				}
			}
			catch(Exception e){
				System.out.println("error");
				e.printStackTrace();
			}
			break;
		case -1:
			try{
				
				String[] temporary=file.getSimilar_artists();
				if(temporary!=null){
					for(int b=0;b<temporary.length;b++){
						for(int a=0;a<data.size();a++){
							if(temporary[b].equals(data.get(a).getArtist_id()) && !temp.contains(data.get(a))){
								temp.add(data.get(a));
							}
						}
					}
					
					
					for(int index = 0; index< temp.size(); index+=2){
						data.remove(temp.get(index));
					}
					
				
				
					
				}
			}
			catch(Exception e){
				System.out.println("error");
				e.printStackTrace();
			}
			break;
			
		case 0:
			
			break;
			
		case -3:
			
			break;
				
		default:
			System.out.println("There was an error!");
		}
	}
	
	private static void tempo(int value,Song file) {
		int rangeSmall=25;
		int rangeBig=35;
		List<Song> temp=new ArrayList<Song>();
		
		switch (value){
		case 2:
			try{
				double temporary=file.getTempo();
				if(temporary!=0){
					
					for(int a=0;a<data.size();a++){
						if(!((data.get(a).getTempo()>temporary-rangeSmall) && (data.get(a).getTempo()<temporary+rangeSmall))){
							if(data.get(a).getTempo()!=0){
								temp.add(data.get(a));
							}
						}
					}
					
					for(int i=0;i<temp.size();i++){
						data.remove(temp.get(i));
					}
				
		
				}
			}
			catch(Exception e){
				System.out.println("error");
				e.printStackTrace();
			}
			break;
			
		case -2:
			try{
				double temporary=file.getTempo();
				if(temporary!=0){
					
					for(int a=0;a<data.size();a++){
						if(((data.get(a).getTempo()>temporary-rangeBig) && (data.get(a).getTempo()<temporary+rangeBig))){
							if(data.get(a).getTempo()!=0){
								temp.add(data.get(a));
							}
						}
					}
					
					for(int i=0;i<temp.size();i++){
						data.remove(temp.get(i));
					}
				
					
				}
			}
			catch(Exception e){
				System.out.println("error");
				e.printStackTrace();
			}
			break;
		
		case 1:
			try{
				double temporary=file.getTempo();
				if(temporary!=0){
					
					for(int a=0;a<data.size();a++){
						if(!((data.get(a).getTempo()>temporary-rangeBig) && (data.get(a).getTempo()<temporary+rangeBig))){
							if(data.get(a).getTempo()!=0){
								temp.add(data.get(a));
							}
						}
					}
					
					for(int i=0;i<temp.size();i++){
						data.remove(temp.get(i));
					}
				
					
				}
			}
			catch(Exception e){
				System.out.println("error");
				e.printStackTrace();
			}
			break;
		case -1:
			try{
				double temporary=file.getTempo();
				if(temporary!=0){
					
					for(int a=0;a<data.size();a++){
						if(((data.get(a).getTempo()>temporary-rangeSmall) && (data.get(a).getTempo()<temporary+rangeSmall))){
							if(data.get(a).getTempo()!=0){
								temp.add(data.get(a));
							}
						}
					}
					
					for(int i=0;i<temp.size();i++){
						data.remove(temp.get(i));
					}
				
					
				}
			}
			catch(Exception e){
				System.out.println("error");
				e.printStackTrace();
			}
			break;
			
		case 0:
			
			break;
			
		case -3:
			
			break;
				
		default:
			System.out.println("There was an error!");
		}
	}
	private static void loudness(int value,Song file) {
		int rangeSmall=4;
		int rangeBig=6;
		List<Song> temp=new ArrayList<Song>();
		
		switch (value){
		case 2:
			try{
				double temporary=file.getLoudness();
				if(temporary!=0){
					
					for(int a=0;a<data.size();a++){
						if(!((data.get(a).getLoudness()>temporary-rangeSmall) && (data.get(a).getLoudness()<temporary+rangeSmall))){
							
							temp.add(data.get(a));
							
						}
					}
					
					for(int i=0;i<temp.size();i++){
						data.remove(temp.get(i));
					}
				
					
				}
			}
			catch(Exception e){
				System.out.println("error");
				e.printStackTrace();
			}
			break;
			
		case -2:
			try{
				double temporary=file.getLoudness();
				if(temporary!=0){
					
					for(int a=0;a<data.size();a++){
						if(((data.get(a).getLoudness()>temporary-rangeBig) && (data.get(a).getLoudness()<temporary+rangeBig))){
						
							temp.add(data.get(a));
							
						}
					}
					
					for(int i=0;i<temp.size();i++){
						data.remove(temp.get(i));
					}
				
					
				}
			}
			catch(Exception e){
				System.out.println("error");
				e.printStackTrace();
			}
			break;
		
		case 1:
			try{
				double temporary=file.getLoudness();
				if(temporary!=0){
					
					for(int a=0;a<data.size();a++){
						if(!((data.get(a).getLoudness()>temporary-rangeBig) && (data.get(a).getLoudness()<temporary+rangeBig))){
							
							temp.add(data.get(a));
							
						}
					}
					
					for(int i=0;i<temp.size();i++){
						data.remove(temp.get(i));
					}
				
					
				}
			}
			catch(Exception e){
				System.out.println("error");
				e.printStackTrace();
			}
			break;
		case -1:
			try{
				double temporary=file.getLoudness();
				if(temporary!=0){
					
					for(int a=0;a<data.size();a++){
						if(((data.get(a).getLoudness()>temporary-rangeSmall) && (data.get(a).getLoudness()<temporary+rangeSmall))){
							temp.add(data.get(a));
							
						}
					}
					
					for(int i=0;i<temp.size();i++){
						data.remove(temp.get(i));
					}
				
					
				}
			}
			catch(Exception e){
				System.out.println("error");
				e.printStackTrace();
			}
			break;
			
		case 0:
			
			break;
			
		case -3:
			
			break;
				
		default:
			System.out.println("There was an error!");
		}
	}
	private static void songHot(int value,Song file) {
		double rangeSmall=0.3;
		double rangeBig=0.9;
		List<Song> temp=new ArrayList<Song>();
		
		switch (value){
		case 2:
			try{
				double temporary=file.getSong_hotttnesss();
				if(temporary!=0){
					
					for(int a=0;a<data.size();a++){
						if(!((data.get(a).getSong_hotttnesss()>temporary-rangeSmall) && (data.get(a).getSong_hotttnesss()<temporary+rangeSmall))){
							if(data.get(a).getSong_hotttnesss()!=0){
								temp.add(data.get(a));
							}
						}
					}
					
					for(int i=0;i<temp.size();i++){
						data.remove(temp.get(i));
					}
				
					
				}
			}
			catch(Exception e){
				System.out.println("error");
				e.printStackTrace();
			}
			break;
			
		case -2:
			try{
				double temporary=file.getSong_hotttnesss();
				if(temporary!=0){
					
					for(int a=0;a<data.size();a++){
						if(((data.get(a).getSong_hotttnesss()>temporary-rangeBig) && (data.get(a).getSong_hotttnesss()<temporary+rangeBig))){
							if(data.get(a).getSong_hotttnesss()!=0){
								temp.add(data.get(a));
							}
						}
					}
					
					for(int i=0;i<temp.size();i++){
						data.remove(temp.get(i));
					}
				
					
				}
			}
			catch(Exception e){
				System.out.println("error");
				e.printStackTrace();
			}
			break;
		
		case 1:
			try{
				double temporary=file.getSong_hotttnesss();
				if(temporary!=0){
					
					for(int a=0;a<data.size();a++){
						if(!((data.get(a).getSong_hotttnesss()>temporary-rangeBig) && (data.get(a).getSong_hotttnesss()<temporary+rangeBig))){
							if(data.get(a).getSong_hotttnesss()!=0){
								temp.add(data.get(a));
							}
						}
					}
					
					for(int i=0;i<temp.size();i++){
						data.remove(temp.get(i));
					}
				
					
				}
			}
			catch(Exception e){
				System.out.println("error");
				e.printStackTrace();
			}
			break;
		case -1:
			try{
				double temporary=file.getSong_hotttnesss();
				if(temporary!=0){
					
					for(int a=0;a<data.size();a++){
						if(((data.get(a).getSong_hotttnesss()>temporary-rangeSmall) && (data.get(a).getSong_hotttnesss()<temporary+rangeSmall))){
							if(data.get(a).getSong_hotttnesss()!=0){
								temp.add(data.get(a));
							}
						}
					}
					
					for(int i=0;i<temp.size();i++){
						data.remove(temp.get(i));
					}
				
					
				}
			}
			catch(Exception e){
				System.out.println("error");
				e.printStackTrace();
			}
			break;
			
		case 0:
			
			break;
			
		case -3:
			
			break;
				
		default:
			System.out.println("There was an error!");
		}
	}
	
	private static void danceability(int value,Song file) {
		double rangeSmall=0.2;
		double rangeBig=0.6;
		List<Song> temp=new ArrayList<Song>();
		
		switch (value){
		case 2:
			try{
				double temporary=file.getDanceability();
				
				if(temporary!=0){
					
					for(int a=0;a<data.size();a++){
						if(!((data.get(a).getDanceability()>temporary-rangeSmall) && (data.get(a).getDanceability()<temporary+rangeSmall))){
							if(data.get(a).getDanceability()!=0){
								temp.add(data.get(a));
							}
						}
					}
					
					for(int i=0;i<temp.size();i++){
						data.remove(temp.get(i));
					}
				
					
				}
			}
			catch(Exception e){
				System.out.println("error");
				e.printStackTrace();
			}
			break;
			
		case -2:
			try{
				double temporary=file.getDanceability();
				if(temporary!=0){
					
					for(int a=0;a<data.size();a++){
						if(((data.get(a).getDanceability()>temporary-rangeBig) && (data.get(a).getDanceability()<temporary+rangeBig))){
							if(data.get(a).getDanceability()!=0){
								temp.add(data.get(a));
							}
						}
					}
					
					for(int i=0;i<temp.size();i++){
						data.remove(temp.get(i));
					}
				
					
				}
			}
			catch(Exception e){
				System.out.println("error");
				e.printStackTrace();
			}
			break;
		
		case 1:
			try{
				double temporary=file.getDanceability();
				if(temporary!=0){
					
					for(int a=0;a<data.size();a++){
						if(!((data.get(a).getDanceability()>temporary-rangeBig) && (data.get(a).getDanceability()<temporary+rangeBig))){
							if(data.get(a).getDanceability()!=0){
								temp.add(data.get(a));
							}
						}
					}
					
					for(int i=0;i<temp.size();i++){
						data.remove(temp.get(i));
					}
				
					
				}
			}
			catch(Exception e){
				System.out.println("error");
				e.printStackTrace();
			}
			break;
		case -1:
			try{
				double temporary=file.getDanceability();
				if(temporary!=0){
					
					for(int a=0;a<data.size();a++){
						if(((data.get(a).getDanceability()>temporary-rangeSmall) && (data.get(a).getDanceability()<temporary+rangeSmall))){
							if(data.get(a).getDanceability()!=0){
								temp.add(data.get(a));
							}
						}
					}
					
					for(int i=0;i<temp.size();i++){
						data.remove(temp.get(i));
					}
				
					
				}
			}
			catch(Exception e){
				System.out.println("error");
				e.printStackTrace();
			}
			break;
			
		case 0:
			
			break;
			
		case -3:
			
			break;
				
		default:
			System.out.println("There was an error!");
		}
	}
}
