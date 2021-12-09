import java.util.ArrayList;

public class reyes_lab13 
{
	public ArrayList<Integer> numbers = new ArrayList<>();
	
	public void readData(String filename)
	{
		try 
		{
			java.util.ArrayList<String> inputLines = new java.util.ArrayList<>(0);
			java.io.BufferedReader input = new java.io.BufferedReader (new java.io.InputStreamReader(new java.io.FileInputStream(filename)));
			String inn;
			while((inn = input.readLine()) != null)
			{
				inputLines.add(inn);
			}
			for(int i = 0; i < inputLines.size(); i++)
			{
				String line = inputLines.get(i);
				java.util.StringTokenizer st = new java.util.StringTokenizer(line);
				String num = st.nextToken();
				int intValue = Integer.parseInt(num);
				numbers.add(intValue);
			}
			input.close();
		}
		catch(Exception e)
		{
			System.out.println(e.toString());
			System.exit(0);
		}
		
	}
	
	public long getTotalCount()
	{
		return numbers.stream().count();
	}
	
	public long getOddCount()
	{
		return numbers.stream().filter(x -> x % 2 != 0).count();
	}
	
	public long getEvenCount()
	{
		return numbers.stream().filter(x -> x % 2 == 0).count();
	}
	
	public long getDistinctGreaterThanFiveCount()
	{
		return numbers.stream().filter(x -> x > 5).distinct().count();
	}
	
	public Integer[] getResult1()
	{
		return numbers.stream().filter(x -> x % 2 == 0).filter(x -> x > 5).filter(x -> x < 50).sorted().toArray(Integer[]::new);
	}
	
	public Integer[] getResult2()
	{
		return numbers.stream().map(x -> x * x * 3).limit(50).toArray(Integer[]::new);
	}
	
	public Integer[] getResult3()
	{
		return numbers.stream().filter(x -> x % 2 != 0).map(x -> x * 2).sorted().skip(20).distinct().toArray(Integer[]::new);
	}

}
