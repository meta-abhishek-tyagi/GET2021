import java.util.*;
class Directory{
	String directoryName; 
	String timestamp;   
	ArrayList<Directory> subDirectories; 
	Directory parentDirectory;  
	
	Directory(String directoryName, Directory parentDirectory){
		this.directoryName = directoryName;
		this.timestamp = new Date().toString();
		this.subDirectories = new ArrayList<>();
		this.parentDirectory = parentDirectory;
	}
}

class VirtualCMD {    	
	private Directory rootDirectory, currentDirectory;
	private ArrayList<String> currentPath;
	
	//construct the root folder when user start the VCMD
	VirtualCMD(){
		rootDirectory = new Directory("\\", null);
		currentDirectory = rootDirectory;
		System.out.println(": : : Welcome to the Virtual Command Prompt : : :");
		currentPath =  new ArrayList<>();
	}
	
	//Run the command that user provide
	void run(String command, String data){
	  switch(command.toLowerCase()){
		case "mkdir" :
			mkdir(data);
			break;
		case "ls" :
			list();
			break;
		case "tree" :
			Directory tempDir = currentDirectory;
			tree(tempDir, 0);
			break;
		case "cd" :
			changeDir(data);
			break;
		case "bk" :
			back();
			break;
		case "find" :
			for(String path:find(data, currentDirectory, new ArrayList<>(), ".\\"))
				System.out.println(path);
	 		break;
		case "exit" :
			System.out.println("Thanks for using VCMD");
			System.exit(0);
		default :
			System.out.println("'" + command + "' is not recognized as an internal or external command, operable program or batch file. ");
	  }
	}
	
	//List all the directories present the working directory
	void list(){
		for(Directory directory:currentDirectory.subDirectories)
			System.out.println(directory.timestamp + "  " + directory.directoryName);
	}
	
	//create the new Directory if not exist
	void mkdir(String folderName){
		if(folderName == null){
			System.out.println("The syntax of command is incorrect");
			return;
		}
		Directory newDirectory = new Directory(folderName, currentDirectory);
		if(isPresent(folderName, currentDirectory)){
			System.out.println(folderName + " is already exist in the directory ");
			return;
		}
		if(currentDirectory == rootDirectory)
			rootDirectory.subDirectories.add(newDirectory);
		else
			currentDirectory.subDirectories.add(newDirectory);
	}
	
	private boolean isPresent(String folderName, Directory currentDirectory) {
		for(Directory dir:currentDirectory.subDirectories){
			if(dir.directoryName.compareTo(folderName) == 0)
				return true;
		}
		return false;
	}

	//return the array of the paths of all the matching folder name
	ArrayList<String> find(String folderName, Directory currentDirectory, ArrayList<String> path, String currentPath){
		if(currentDirectory.directoryName.contains(folderName)) 
			path.add(currentPath);
		for(Directory dir:currentDirectory.subDirectories)
			find(folderName, dir, path, currentPath + dir.directoryName + "\\");
		return path;
	}
	
	//print spaces while printing the tree for subDirectories
	void printSpace(int level){
		if(level != 0)
			System.out.print("|");
		for(int space = level; space > 0; space--)
			System.out.print("\t");
	}
	
	//print the directory structure
	void tree(Directory dir, int level){
		for(Directory subDir : dir.subDirectories){
			printSpace(level);
			System.out.println("|");
			printSpace(level);
			System.out.println("|-----" + subDir.directoryName);
			if(subDir.subDirectories.size() > 0)
				tree(subDir, level+1);
		}
	}
	
	//change the directory
	void changeDir(String folderName){
		for(Directory directory : currentDirectory.subDirectories){
			if(directory.directoryName.compareTo(folderName) == 0){
				currentPath.add(directory.directoryName);
				currentDirectory = directory;
				return;
			}
		}
		System.out.println("The system cannot find the path specified.");
	}
	
	//go back to parent directory
	void back(){
		if(currentPath.size() > 0){
			currentDirectory = currentDirectory.parentDirectory;
			currentPath.remove(currentPath.size()-1);
		}
	}
	
	//return the current working directory path
	String getPath(){
		String path = rootDirectory.directoryName;
		for(String dirName : currentPath){
			if(dirName.compareTo("\\") == 0 || path.compareTo("\\") == 0)
				path += dirName;
			else
				path += "\\" + dirName;
		}
		return path;
	}

	public static void main(String[] args){
		Scanner sc = new Scanner(System.in);
		VirtualCMD vcmd = new VirtualCMD();
		while(true){
			System.out.print("C:" + vcmd.getPath() + ">");
			String[] cmd = sc.nextLine().split(" ");
			if(cmd.length == 2)
				vcmd.run(cmd[0], cmd[1]);
			else
				vcmd.run(cmd[0], null);
		}
	}
}
