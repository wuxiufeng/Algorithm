#include <iostream>
#include <vector>
using namespace std;

struct m
{
    unsigned long long int l,r,m;
};
int main()
{
    int t;
    cin>>t;
    while(t--)
    {
        unsigned long long int n,q,l,r;
        vector <m> p;
        cin>>n;
        cin>>q;
        int lo,ro=0,u=1;
        for(unsigned long long int i=0;i<n;i++)
        {
            cin>>l;
            cin>>r;

            //cout<<u<<"*";
            struct m w={l,r,u};
            p.push_back(w);
            u=u+r-l+1;
        }
        unsigned long long int last=p[n-1].m+p[n-1].r-p[n-1].l;
        for(unsigned long long int i=0;i<q;i++)
        {
            unsigned long long int y;
            cin>>y;
            for(unsigned long long int j=0;j<n;j++)
            {
            	//cout<<"\n"<<p[j].m+p[j].r-p[j].l;
                if(p[j].m<=y && p[j].m+p[j].r-p[j].l>=y)
                {
                	//cout<<"m="<<p[j].m<<"\n";
                	unsigned long long int g=p[j].l+y-p[j].m;
                    cout<<g<<" ";
                    //cout<<y+lo+p[j].m-1<<" ";
                    break;
                }
                if(y>last)
                {
                    unsigned long long int g=p[n-1].r+y-last;
                	cout<<g<<" ";
                	break;
                }
            }
        }
        cout<<"\n";

    }
    return 0;
}
