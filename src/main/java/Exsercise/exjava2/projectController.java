/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Exsercise.exjava2;

import javax.servlet.http.HttpServletRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
/**
 *
 * @author Belinda merlansyah
 */
@Controller
public class projectController {
    
    @RequestMapping("/input")
    public String getData(HttpServletRequest data, Model discountprocess){
        
        String inputname = data.getParameter("var_name");
        
        String inputprice = data.getParameter("var_price");
        
        String inputquantity = data.getParameter("var_quantity");
        
        String inputMoney = data.getParameter("var_money");
        
        String keterangan = data.getParameter("ket");
        
        String diskon = "";
        
        Double iPrice = Double.valueOf(inputprice);
        Double iTotal = Double.valueOf(inputquantity);
        Double iMoney = Double.valueOf(inputMoney);
        Double PriceTotal = iPrice * iTotal;
        Double getTotal = null;
        Double totalDiskon = null;
       
        if (PriceTotal < 16000)
        {
            getTotal = PriceTotal - (0 * PriceTotal/100);
            diskon = "0%";
            totalDiskon = 0*PriceTotal/100;
        }
        else if (PriceTotal >= 16000 && PriceTotal < 25000)
        {
            getTotal = PriceTotal - (10 * PriceTotal/100);
            diskon = "10%";
            totalDiskon = 10*PriceTotal/100;
        }
        else if (PriceTotal >= 25000)
        {
            getTotal = PriceTotal - (15 * PriceTotal/100);
            diskon = "15%";
            totalDiskon = 15*PriceTotal/100;
        }
       
        Double kembali = iMoney - getTotal;
        Double kurang = getTotal - iMoney;
        
        if (iMoney < iTotal)
        {
            keterangan = "Kembalian anda Rp. " + kembali;
        }
        
        else if (iMoney > iTotal)
        {
            keterangan = "Uang anda kurang Rp. " + kurang;
        }
                
        discountprocess.addAttribute("name", inputname);
        discountprocess.addAttribute("price", inputprice);
        discountprocess.addAttribute("quantity", inputquantity);
        discountprocess.addAttribute("total", getTotal);
        discountprocess.addAttribute("diskon", diskon);
        discountprocess.addAttribute("money", inputMoney);
        discountprocess.addAttribute("totalDiskon", totalDiskon);
        discountprocess.addAttribute ("ket", keterangan);
        
        return "Belinda";
    }    
}
