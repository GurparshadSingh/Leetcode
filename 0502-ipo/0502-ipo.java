class Solution {
    class Project {
        int capital;
        int profit;

        Project(int capital, int profit) {
            this.capital = capital;
            this.profit = profit;
        }
    }

    public int findMaximizedCapital(int k, int w, int[] profits, int[] capital) {
        int n = profits.length;
        Project[] project = new Project[n];
        
        for(int i = 0;i<n;i++){
            project[i]=new Project(capital[i],profits[i]);
        }

        Arrays.sort(project,(a,b)->{
            return a.capital-b.capital;
        });


        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        int maxProfit;
        int index = 0;
        for (int i = 0; i < k; i++) {
            while (index < n && project[index].capital <= w) {
                pq.offer(project[index].profit);
                index++;
            }
            if(pq.isEmpty()){
                break;
            }
            maxProfit = pq.poll();
            w += maxProfit;
        }
        return w;

    }
}