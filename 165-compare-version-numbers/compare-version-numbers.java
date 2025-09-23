class Solution {
    public int compareVersion(String version1, String version2) {
        ArrayList<Integer> v1 = new ArrayList<>();
        ArrayList<Integer> v2 = new ArrayList<>();
        int n1 = version1.length(), n2 = version2.length();
        int num1 = 0, num2 = 0;

        for (int i = 0; i < n1; i++) 
        {
            if (version1.charAt(i) != '.') {
                num1 = (num1 * 10) + (version1.charAt(i) - '0');
            } 
            else {
                v1.add(num1);
                num1 = 0;
            }
        }
        v1.add(num1);

        for (int i = 0; i < n2; i++) 
        {
            if (version2.charAt(i) != '.') {
                num2 = (num2 * 10) + (version2.charAt(i) - '0');
            } 
            else {
                v2.add(num2);
                num2 = 0;
            }
        }
        v2.add(num2);

        int i, minLen = Math.min(v1.size(), v2.size());
        for (i = 0; i < minLen; i++) 
        {
            if (v1.get(i) > v2.get(i)) {
                return 1;
            } 
            else if (v1.get(i) < v2.get(i)) {
                return -1;
            }
        }

        while (i < v1.size()) 
        {
            if (v1.get(i) > 0) {
                return 1;
            } 
            else if (v1.get(i) < 0) {
                return -1;
            }
            i++;
        }

        while (i < v2.size()) 
        {
            if (v2.get(i) < 0) {
                return 1;
            } 
            else if (v2.get(i) > 0) {
                return -1;
            }
            i++;
        }

        return 0;
    }
}