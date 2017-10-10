package com.shaunz.framework.example.jqgrid;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
 
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import com.shaunz.framework.common.utils.JsonUtil;
import com.shaunz.framework.example.jqgrid.JQGridDTO;
import com.shaunz.framework.example.jqgrid.SuperHeroDTO;
import com.shaunz.framework.example.jqgrid.JQGridHandler;
/**
 * This class acts as the controller for JQGrid related functionality.
 *
 * @author Dinuka Arseculeratne
 *
 */
@Controller
public class JQGridController {
 
 /**
  * This method will display the page used to display the grid.
  *
  * @param req
  * @param res
  * @return
  */
 @RequestMapping(method = { RequestMethod.POST, RequestMethod.GET }, value = "/jqGridExample")
 public String jqGrid(HttpServletRequest req, HttpServletResponse res) {
  String forward = "jqgrid/jqGridData";
  return forward;
 }
 /**
  * This method will handle fetching data required for the JQGrid.
  *
  * @param req
  * @param res
  * @return
  */
 @RequestMapping(method = { RequestMethod.POST, RequestMethod.GET }, value = "/loadData")
 public String loadData(HttpServletRequest req, HttpServletResponse res) {
  String forward = "common/formData";
 
  JQGridDTO<SuperHeroDTO> gridData = new JQGridHandler().loadSuperHeroes(req);
  req.setAttribute("formData", JsonUtil.toJsonObj(gridData));
  return forward;
 }
}