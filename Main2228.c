#include <stdio.h>
#include <limits.h>

int dp[110][110];
int check[110][110];
int sum[110];

int solve(int n, int m)
{
	int i;
	int temp;
	
	if (m == 0) return 0;
	if (n < 0) return INT_MIN / 2;
	if (check[n][m]) return dp[n][m];

	check[n][m] = 1;
	dp[n][m] = solve(n - 1, m);

	for (i = n; i > 0; i--) {
		temp = solve(i - 2, m - 1) + sum[n] - sum[i - 1];
		if (temp > dp[n][m]) dp[n][m] = temp;
	}
	return dp[n][m];
}

int main()
{
	int n, m;
	int i;
	int data;

	scanf_s("%d %d", &n, &m);

	for (i = 1; i <= n; i++) {
		scanf_s("%d", &data);
		sum[i] = sum[i - 1] + data;
	}

	printf("%d\n", solve(n, m));

	return 0;
}