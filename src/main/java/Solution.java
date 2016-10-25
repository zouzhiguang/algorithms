import java.io.*;
import java.util.*;
import java.util.stream.Collectors;

public class Solution {

    public static void main(String[] args) throws IOException {

        List<String> inputs = readAllLines();

        Set<String>  keywords = new HashSet<>();
        String keywordString = inputs.get(0);
        for (String keyword : keywordString.split(" ")) {
            keywords.add(keyword.trim());
        }

        Map<Integer, Review> reviews = new HashMap<>();
        for(int i = 2; i < inputs.size() ; i+= 2){
            int id = Integer.parseInt(inputs.get(i));
            Review review = reviews.get(id);
            if(review == null){
                review = new Review(id);
                reviews.put(id, review);
            }

            for (String s : inputs.get(i + 1).split(" ")) {
                if(s.startsWith(",") || s.startsWith(".")){
                    s = s.substring(1);
                }

                if(s.endsWith(",") || s.endsWith(".")){
                    s = s.substring(0, s.length() - 1);
                }

                if(keywords.contains(s)){
                    review.count++;
                }
            }
        }

        List<Review> results = reviews.values().stream().sorted().collect(Collectors.toList());

        for (int i = 0; i < results.size(); i++){
            if(i > 0){
                System.out.print(" ");
            }
            System.out.print("" + results.get(i).id);
        }
    }

    static class Review implements Comparable<Review>{
        int id;
        int count;

        Review(int id){
            this.id = id;
        }

        @Override
        public int compareTo(Review o) {
            // descending order
            return o.count - count == 0 ? o.id  - id : o.count - count;
        }
    }

    public static List<String> readAllLines() throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        List<String> lines = new ArrayList<>();
        String line;
        while ((line = reader.readLine()) != null){
            lines.add(line);

        }

        return lines;
    }
}
