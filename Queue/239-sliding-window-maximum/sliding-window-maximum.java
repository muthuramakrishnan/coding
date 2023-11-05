class Solution {
    public int[] maxSlidingWindow(int[] arr, int k) {
        int n = arr.length;
        List<Integer> outputArrList = new ArrayList<>();
        Deque<Integer> queue = new ArrayDeque<>(k);
        queue.add(0);
        for (int i = 1; i < k; i++) {
            int lastElIdx = queue.peekLast();
            int lastEl = arr[lastElIdx];
            while (lastEl <= arr[i]) {
                queue.removeLast();
                if (queue.isEmpty()) {
                    break;
                }
                lastElIdx = queue.peekLast();
                lastEl = arr[lastElIdx];
            }
            queue.add(i);
        }

        for (int i = k; i < n; i++) {
            int firstIdx = queue.peekFirst();
            int firstEl = arr[firstIdx];
            outputArrList.add(firstEl);

            boolean shouldKickOutFirstEl = i - k == firstIdx;
            if (shouldKickOutFirstEl) {
                queue.removeFirst();
            }
            if (!queue.isEmpty()) {
                int lastElIdx = queue.peekLast();
                int lastEl = arr[lastElIdx];
                while (lastEl <= arr[i]) {
                    queue.removeLast();
                    if (queue.isEmpty()) {
                        break;
                    }
                    lastElIdx = queue.peekLast();
                    lastEl = arr[lastElIdx];
                }
                queue.add(i);
            } else {
                queue.add(i);
            }
        }

        if(!queue.isEmpty()){
            outputArrList.add(arr[queue.pollFirst()]);
        }
        return outputArrList.stream().mapToInt(i -> i).toArray();
    }
}