class Solution {
  public boolean hasSameDigits(String s) {
    int[] a = new int[s.length()];
    for (int i = 0; i < a.length; i++)
      a[i] = s.charAt(i) - '0';
    for (int length = a.length; length > 2; length--) {
      for (int i = 0; i < length - 1; i++) {
        a[i] = (a[i] + a[i + 1]) % 10;
      }
    }
    return a[0] == a[1]; 
  }
}