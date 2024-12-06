#include<bits/stdc++.h>
 using namespace std;

// n l� s? d?nh, e l� s? c?nh
int n,e,i,j; 
vector<vector<int> > doThi;
vector<int> mau;
bool daTham[1000];


void ToMauDoThi()
{
    mau[0]  = 0;  // t� m�u d?nh d?u ti�n l� m�u 0
    
    for (i = 1; i < n; ++i)
        mau[i] = -1;  // d?t m�u c�c d?nh c�n l?i l� chua t�

    bool mauChuaDung[n];  // ki?m tra c�c m�u chua d�ng 
 
    for (i = 0; i < n; ++i)
        mauChuaDung[i]= false;   // d?t c�c m�u ban d?u d?u chua d�ng
 
    for (i = 1; i < n; ++i)   // b?t d?u t� m�u
    {
        for (j=0;j<doThi[i].size(); ++j)   // ki?m tra c�c d?nh k? d� du?c t� chua
            if (mau[doThi[i][j]] != -1)   // n?u d?nh k? d� du?c t� th� m�u d� du?c d?t l� d� s? d?ng
                mauChuaDung[mau[doThi[i][j]]] = true;
        
        // t�m m�u d?u ti�n chua d�ng
        int c; 
        for ( c = 0; c < n; ++c)
            if (mauChuaDung[c] == false)   // n?u t�m th?y m�u chua d�ng th� d?ng t�m
                break;
 
        mau[i] = c;   // t� m�u d?nh i b?ng m�u c
        // d?t l?i tr?ng th�i m�u cho c�c m�u d? b?t d?u v�ng l?p t� m�u cho c�c d?nh sau
        for ( j = 0; j < doThi[i].size(); ++j)
            if (mau[doThi[i][j]] != -1) 
              mauChuaDung[mau[doThi[i][j]]] = false;
    }
}


void nhap_ban_phim(){
  int x,y;
    cout<<"Nhap lan luot so dinh va so canh cua do thi :";
    cin>>n>>e;
    cout<<"\n";
    doThi.resize(n);
    mau.resize(n);
    memset(daTham,0,sizeof(daTham));
    for(i=0;i<e;i++)
    {
        cout<<"\nNhap canh thu "<<i+1<<" : ";
        cin>>x>>y;
        
        x--; y--;
        doThi[x].push_back(y);
        doThi[y].push_back(x);
    }
}

void doc_tu_file(string tenfile) {
    ifstream file(tenfile.c_str());
    if (!file) {
        cout << "Khong the mo tep " << tenfile << "\n";
        return;
    }
    int x, y;
    file >> n >> e;
    
    doThi.resize(n);
    mau.resize(n);
    memset(daTham,0,sizeof(daTham));
    for (i = 0; i < e; i++) {
        file >> x >> y;
        x--; y--;
        doThi[x].push_back(y);
        doThi[y].push_back(x);
    }
    
    file.close();
}

void dfs(int v) {
    daTham[v] = true;
    for (int i = 0; i < doThi[v].size(); i++) {
        int ke = doThi[v][i];  
        if (!daTham[ke]) dfs(ke);
    }
}

bool lienthong() {
    dfs(0);
    for (int i = 0; i < n; i++) {
        if (!daTham[i]) return false;
    }
    return true;
}


int main()
{
    int nhap;
    cout<<"Chon phuong thuc nhap:\n";
    cout<<"1. Nhap tu ban phim\n";
    cout<<"2. Doc tu file\n";
    cout<<"Chon? "; cin>>nhap;
    if(nhap == 1) 
      nhap_ban_phim();
    else if(nhap == 2) {
      string tenfile;
      cout<<"Nhap ten file: "; cin>>tenfile;
      doc_tu_file(tenfile);
    }
    else {
      cout<<"Khong hop le\n";
      return 0;
    }
    if(lienthong()) {
        ToMauDoThi();
        for(i=0;i<n;i++)
        {
            cout<<"Dinh "<<i+1<<" duoc to mau "<<mau[i]+1<<"\n";
        }
    } else cout<<"Do Thi khong lien thong\n";
    return 0;
}
