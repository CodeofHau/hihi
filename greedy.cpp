#include<bits/stdc++.h>
 using namespace std;

// n là s? d?nh, e là s? c?nh
int n,e,i,j; 
vector<vector<int> > doThi;
vector<int> mau;
bool daTham[1000];


void ToMauDoThi()
{
    mau[0]  = 0;  // tô màu d?nh d?u tiên là màu 0
    
    for (i = 1; i < n; ++i)
        mau[i] = -1;  // d?t màu các d?nh còn l?i là chua tô

    bool mauChuaDung[n];  // ki?m tra các màu chua dùng 
 
    for (i = 0; i < n; ++i)
        mauChuaDung[i]= false;   // d?t các màu ban d?u d?u chua dùng
 
    for (i = 1; i < n; ++i)   // b?t d?u tô màu
    {
        for (j=0;j<doThi[i].size(); ++j)   // ki?m tra các d?nh k? dã du?c tô chua
            if (mau[doThi[i][j]] != -1)   // n?u d?nh k? dã du?c tô thì màu dó du?c d?t là dã s? d?ng
                mauChuaDung[mau[doThi[i][j]]] = true;
        
        // tìm màu d?u tiên chua dùng
        int c; 
        for ( c = 0; c < n; ++c)
            if (mauChuaDung[c] == false)   // n?u tìm th?y màu chua dùng thì d?ng tìm
                break;
 
        mau[i] = c;   // tô màu d?nh i b?ng màu c
        // d?t l?i tr?ng thái màu cho các màu d? b?t d?u vòng l?p tô màu cho các d?nh sau
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
