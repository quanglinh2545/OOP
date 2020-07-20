public class MapExample {
public static void main(String args[]) {
Map map = new HashMap();
Integer ONE = new Integer(1);
for (int i=0, n=args.length; i<n; i++) {
String key = args[i];
Integer frequency =(Integer)map.get(key);
if (frequency == null) { frequency = ONE; }
else {
int value = frequency.intValue();
frequency = new Integer(value + 1);
}
map.put(key, frequency);
}
System.out.println(map);
Map sortedMap = new TreeMap(map);
System.out.println(sortedMap);
}
}