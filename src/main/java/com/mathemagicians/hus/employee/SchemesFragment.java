package com.mathemagicians.hus.employee;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.mathemagicians.hus.R;

/**
 * Created by SHLOK on 21-01-2017.
 */

public class SchemesFragment extends Fragment{
    TextView t1, t2, t3, t4;
    String url1 = "http://www.google.co.in/url?sa=t&rct=j&q=&esrc=s&source=web&cd=3&cad=rja&uact=8&ved=0ahUKEwjZ6qqI9tLRAhWHt48KHc3YDZwQFggmMAI&url=https%3A%2F%2Fen.wikipedia.org%2Fwiki%2FUnorganised_Workers%27_Social_Security_Act_2008&usg=AFQjCNEhdeaiUxfFvfdQoVZdGW28fNiNGw&sig2=45yss-bwnFMS6sWCWIb6cA";
    String url4 = "http://www.google.co.in/url?sa=t&rct=j&q=&esrc=s&source=web&cd=2&cad=rja&uact=8&sqi=2&ved=0ahUKEwjXwMjK9tLRAhUMtY8KHRbaC5EQFggkMAE&url=http%3A%2F%2Fwww.rsby.gov.in%2Fabout_rsby.aspx&usg=AFQjCNG9brPLklbnYQf9NHn2rks34jy9MQ&sig2=ZlIsS1HQR8IOmIDGTV08pg&bvm=bv.144224172,d.c2I";
    String url2 = "http://www.google.co.in/url?sa=t&rct=j&q=&esrc=s&source=web&cd=4&cad=rja&uact=8&ved=0ahUKEwjg_sSe9tLRAhVEqY8KHQLCCS4QFggrMAM&url=http%3A%2F%2Fwww.novamining.com%2Fknowledgebase%2Findian-mining-regulations%2Flabour%2Flegislation%2Funorganised-workers-social-security-act-rules-2008%2F&usg=AFQjCNEmHNprwpmUzjxN8JAjjJ1ubvfcxA&sig2=3VAPL8iTjCj8SwwkuajsKw&bvm=bv.144224172,d.c2I";
    String url3 = "http://www.google.co.in/url?sa=t&rct=j&q=&esrc=s&source=web&cd=4&cad=rja&uact=8&ved=0ahUKEwjTu7a79tLRAhWDuI8KHfI5AMAQFggsMAM&url=http%3A%2F%2Fwww.gktoday.in%2Faam-aadmi-bima-yojana%2F&usg=AFQjCNGdQyvcZ-NbZ_Rp7tnYGiEX0173hA&sig2=iDHrhyd6MGhMgrrEIu_Kbg&bvm=bv.144224172,d.c2I";

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_schemes_1, container, false);

        t1 = (TextView) rootView.findViewById(R.id.t1);
        t2 = (TextView) rootView.findViewById(R.id.t2);
        t3 = (TextView) rootView.findViewById(R.id.t3);
        t4 = (TextView) rootView.findViewById(R.id.t4);


        return rootView;
    }

    public void t1(View v) {
        Intent i = new Intent(Intent.ACTION_VIEW, Uri.parse(url1));
        startActivity(i);
    }

    public void t2(View v) {
        Intent i = new Intent(Intent.ACTION_VIEW, Uri.parse(url2));
        startActivity(i);
    }

    public void t3(View v) {
        Intent i = new Intent(Intent.ACTION_VIEW, Uri.parse(url3));
        startActivity(i);
    }

    public void t4(View v) {
        Intent i = new Intent(Intent.ACTION_VIEW, Uri.parse(url4));
        startActivity(i);
    }
}