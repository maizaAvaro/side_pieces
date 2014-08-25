
import java.awt.Color;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;

public class GreenScreen {

	public static BufferedImage getImage(String inputFile1, String inputFile2, String colorFilter){
		
		BufferedImage inputImage1 = null;
		BufferedImage inputImage2 = null;
		BufferedImage modImage = null;
		
		Color screenColor = Color.green;
		
		try{
			
			
			String inp2 = inputFile2;
			String inp1 = inputFile1;
			
			
			inputImage1 = ImageIO.read(new File(inp1));
			inputImage2 = ImageIO.read(new File(inp2));
			
			int width1 = 0;
			int height1 = 0;
			int width2 = 0;
			int height2 = 0;
			width1 = inputImage1.getWidth();
			height1 = inputImage1.getHeight();
			width2 = inputImage2.getWidth();
			height2 = inputImage2.getHeight();
			
			if((width1+height1)!=(width2+height2)){
				
				System.out.println("The files you have entered for manipulation are not of equal size.\nSome modified image distortion may occur.");
			}
			
			int[] modArray = new int[(height1*width1)];
			
			int color = 0;
			
			if(colorFilter.equalsIgnoreCase("white")){
				
				screenColor = Color.white;
				
			} else if(colorFilter.equalsIgnoreCase("green")){
				
				
			} else if(colorFilter.equalsIgnoreCase("auto")){
				
				int background = inputImage1.getRGB(width1-1, height1-1);
				Color autoBackground = new Color(background);
				screenColor = autoBackground;
				
			} else{
				
				System.out.println("You have entered an invalid background color.\nThe choices available for background color are:  green, white, auto");
				System.exit(0);
				
			}
			
			for(int y = 0, i = 0; y < height1; y++){
				
				for(int x = 0; x < width1; x++){
					
					color = inputImage1.getRGB(x, y);
					
					if(color == screenColor.getRGB()){
						
						modArray[i++] = inputImage2.getRGB(x, y);

					}	else{
						
							modArray[i++] = inputImage1.getRGB(x, y);
						
					}
					
				}
			}
			
			modImage = new BufferedImage(width1, height1, BufferedImage.TYPE_INT_RGB);
			modImage.setRGB(0, 0, width1, height1, modArray, 0, width1);
			
		}	catch (IOException e){
			
			System.out.println("The program has encountered an error in attempting to input the desired images.\nCheck that the input is of a supported type, i.e .png extension.");
			e.getMessage();
			e.printStackTrace();
			System.exit(0);
			
		}	catch (ArrayIndexOutOfBoundsException e2){
			
			System.out.println("The program has encountered a pixel value that is out of range for the given image.");
			e2.getMessage();
			e2.printStackTrace();
			System.exit(0);
			
		}
		
		return modImage;
		
	}

	public static void writeImage(String inputFile1, String inputFile2, String modifiedFile, String fileType, String colorFilter){
		
		BufferedImage save = null;
		save = getImage(inputFile1, inputFile2, colorFilter);
		
		
		try{
			
				if(!(fileType.equalsIgnoreCase("png")) && !(fileType.equalsIgnoreCase("jpg"))){
				
					System.out.println("The designated file type is not supported and thus cannot output a modified image.\nPlease save the file as either a png or jpg.");
					System.exit(0);
					
				}
				
			ImageIO.write(save, fileType, new File(modifiedFile+"."+fileType));
			System.out.println("File Created!");
			
		} catch (IOException e1){
			
			System.out.println("The program has encountered an error in attempting to output the modified image.\nCheck that the output type is supported.");
			e1.getMessage();
			e1.printStackTrace();
			System.exit(0);
			
		} catch (IllegalArgumentException e3){
			
			System.out.println("The program has encountered an error in attempting to output the modified image.\nThe image may have return as a null set.");
			e3.getMessage();
			e3.printStackTrace();
			System.exit(0);
			
		}

	}
	
	public static void main(String[] args) {
		
		if(args.length < 5){
			
			System.out.println("There were too few arguments entered.");
			System.exit(0);
			
		}
		
		writeImage(args[0], args[1], args[2], args[3], args[4]);
		
		}

}
