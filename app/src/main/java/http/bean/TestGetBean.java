package http.bean;

import java.util.List;

/**
 * Created by LiHT on 2017/5/26.
 */

public class TestGetBean {

    /**
     * code : 200
     * datas : {"type_list":[{"type_name":"能量棒与零食榜","order_key":"0/10/20/30","type_id":"47","type_sort":"1","class_id":"1057","type_img":"","class_name":"运动健身","type_index":0},{"type_name":"蛋白粉和高蛋白能量棒","order_key":"0/10/20/30","type_id":"48","type_sort":"2","class_id":"1057","type_img":"","class_name":"运动健身","type_index":0},{"type_name":"超级食品","order_key":"0/10/20/30","type_id":"49","type_sort":"3","class_id":"1057","type_img":"","class_name":"运动健身","type_index":0},{"type_name":"营养饮品","order_key":"0/10/20/30","type_id":"50","type_sort":"4","class_id":"1057","type_img":"","class_name":"运动健身","type_index":0},{"type_name":"健康保健","order_key":"0/10/20/30","type_id":"51","type_sort":"5","class_id":"1057","type_img":"","class_name":"运动健身","type_index":1},{"type_name":"世外香格专有产品","order_key":"0/10/20/30","type_id":"52","type_sort":"6","class_id":"1057","type_img":"","class_name":"运动健身","type_index":2},{"type_name":"专题文章","order_key":"0/10/20/30","type_id":"53","type_sort":"7","class_id":"1057","type_img":"","class_name":"运动健身","type_index":2},{"type_name":"超级食品","order_key":"0/10/20/30","type_id":"56","type_sort":"8","class_id":"1059","type_img":"","class_name":"有机食品","type_index":2},{"type_name":"健康甜味剂、食油、香料、调味品和盐","order_key":"0/10/20/30","type_id":"57","type_sort":"9","class_id":"1059","type_img":"","class_name":"有机食品","type_index":2},{"type_name":"健康零食","order_key":"0/10/20/30","type_id":"58","type_sort":"10","class_id":"1059","type_img":"","class_name":"有机食品","type_index":2},{"type_name":"早餐食品、有机奶粉","order_key":"0/10/20/30","type_id":"59","type_sort":"11","class_id":"1059","type_img":"","class_name":"有机食品","type_index":2},{"type_name":"营养饮品","order_key":"0/10/20/30","type_id":"60","type_sort":"12","class_id":"1059","type_img":"","class_name":"有机食品","type_index":2},{"type_name":"蛋白粉和补品","order_key":"0/10/20/30","type_id":"62","type_sort":"13","class_id":"1059","type_img":"","class_name":"有机食品","type_index":2},{"type_name":"专题文章","order_key":"0/10/20/30","type_id":"64","type_sort":"14","class_id":"1059","type_img":"","class_name":"有机食品","type_index":2},{"type_name":"世外香格专有产品","order_key":"0/10/20/30","type_id":"63","type_sort":"15","class_id":"1059","type_img":"","class_name":"有机食品","type_index":2},{"type_name":"儿童食品和健康零食","order_key":"0/10/20/30","type_id":"65","type_sort":"16","class_id":"1058","type_img":"","class_name":"婴童保健","type_index":2},{"type_name":"儿童增强智力免疫力健康食品","order_key":"0/10/20/30","type_id":"66","type_sort":"17","class_id":"1058","type_img":"","class_name":"婴童保健","type_index":2},{"type_name":"婴儿沐浴和成人美容护理品","order_key":"0/10/20/30","type_id":"67","type_sort":"18","class_id":"1058","type_img":"","class_name":"婴童保健","type_index":2},{"type_name":"宝宝喂养","order_key":"0/10/20/30","type_id":"68","type_sort":"19","class_id":"1058","type_img":"","class_name":"婴童保健","type_index":2},{"type_name":"准妈妈营养","order_key":"0/10/20/30","type_id":"69","type_sort":"20","class_id":"1058","type_img":"","class_name":"婴童保健","type_index":2},{"type_name":"超级食品","order_key":"0/10/20/30","type_id":"70","type_sort":"21","class_id":"1058","type_img":"","class_name":"婴童保健","type_index":2},{"type_name":"专题文章","order_key":"0/10/20/30","type_id":"73","type_sort":"22","class_id":"1058","type_img":"","class_name":"婴童保健","type_index":2},{"type_name":"蛋白粉和补品","order_key":"0/10/20/30","type_id":"71","type_sort":"23","class_id":"1058","type_img":"","class_name":"婴童保健","type_index":2},{"type_name":"世外香格专有产品","order_key":"0/10/20/30","type_id":"72","type_sort":"24","class_id":"1058","type_img":"","class_name":"婴童保健","type_index":2},{"type_name":"儿童保健品","order_key":"0/10/20/30","type_id":"74","type_sort":"25","class_id":"1060","type_img":"","class_name":"维生素补","type_index":2},{"type_name":"抗癌补充剂及补品","order_key":"0/10/20/30","type_id":"75","type_sort":"26","class_id":"1060","type_img":"","class_name":"维生素补","type_index":2},{"type_name":"多种维生素","order_key":"0/10/20/30","type_id":"76","type_sort":"27","class_id":"1060","type_img":"","class_name":"维生素补","type_index":2},{"type_name":"女性健康保健品","order_key":"0/10/20/30","type_id":"77","type_sort":"28","class_id":"1060","type_img":"","class_name":"维生素补","type_index":2},{"type_name":"男性健康保健品","order_key":"0/10/20/30","type_id":"78","type_sort":"29","class_id":"1060","type_img":"","class_name":"维生素补","type_index":2},{"type_name":"超级食品","order_key":"0/10/20/30","type_id":"79","type_sort":"30","class_id":"1060","type_img":"","class_name":"维生素补","type_index":2},{"type_name":"专题文章","order_key":"0/10/20/30","type_id":"81","type_sort":"31","class_id":"1060","type_img":"","class_name":"维生素补","type_index":2},{"type_name":"世外香格专有产品","order_key":"0/10/20/30","type_id":"80","type_sort":"32","class_id":"1060","type_img":"","class_name":"维生素补","type_index":2},{"type_name":"抗癌补充剂及补品","order_key":"0/10/20/30","type_id":"82","type_sort":"33","class_id":"1102","type_img":"","class_name":"抗癌补品","type_index":2},{"type_name":"蛋白粉和能量补品","order_key":"0/10/20/30","type_id":"83","type_sort":"34","class_id":"1102","type_img":"","class_name":"抗癌补品","type_index":2},{"type_name":"多种维生素","order_key":"0/10/20/30","type_id":"84","type_sort":"35","class_id":"1102","type_img":"","class_name":"抗癌补品","type_index":2},{"type_name":"女性保健营养品","order_key":"0/10/20/30","type_id":"85","type_sort":"36","class_id":"1102","type_img":"","class_name":"抗癌补品","type_index":2},{"type_name":"男性保健营养品","order_key":"0/10/20/30","type_id":"86","type_sort":"37","class_id":"1102","type_img":"","class_name":"抗癌补品","type_index":2},{"type_name":"超级食品","order_key":"0/10/20/30","type_id":"87","type_sort":"38","class_id":"1102","type_img":"","class_name":"抗癌补品","type_index":2},{"type_name":"专题文章","order_key":"0/10/20/30","type_id":"89","type_sort":"39","class_id":"1102","type_img":"","class_name":"抗癌补品","type_index":2},{"type_name":"世外香格专有产品","order_key":"0/10/20/30","type_id":"88","type_sort":"40","class_id":"1102","type_img":"","class_name":"抗癌补品","type_index":2},{"type_name":"超级食品","order_key":"0/10/20/30","type_id":"90","type_sort":"41","class_id":"1061","type_img":"","class_name":"专家选择","type_index":2},{"type_name":"营养饮品","order_key":"0/10/20/30","type_id":"91","type_sort":"42","class_id":"1061","type_img":"","class_name":"专家选择","type_index":2},{"type_name":"能量棒与零食棒","order_key":"0/10/20/30","type_id":"92","type_sort":"43","class_id":"1061","type_img":"","class_name":"专家选择","type_index":2},{"type_name":"男性营养品","order_key":"0/10/20/30","type_id":"93","type_sort":"44","class_id":"1061","type_img":"","class_name":"专家选择","type_index":2},{"type_name":"女性营养品","order_key":"0/10/20/30","type_id":"94","type_sort":"45","class_id":"1061","type_img":"","class_name":"专家选择","type_index":2},{"type_name":"蛋白粉和补品","order_key":"0/10/20/30","type_id":"95","type_sort":"46","class_id":"1061","type_img":"","class_name":"专家选择","type_index":2},{"type_name":"专题文章","order_key":"0/10/20/30","type_id":"97","type_sort":"47","class_id":"1061","type_img":"","class_name":"专家选择","type_index":2},{"type_name":"世外香格专有产品","order_key":"0/10/20/30","type_id":"96","type_sort":"48","class_id":"1061","type_img":"","class_name":"专家选择","type_index":2},{"type_name":"抗癌补充剂及补品","order_key":"0/10/20/30","type_id":"98","type_sort":"49","class_id":"1062","type_img":"","class_name":"最新产品","type_index":2},{"type_name":"超级食品","order_key":"0/10/20/30","type_id":"99","type_sort":"50","class_id":"1062","type_img":"","class_name":"最新产品","type_index":2},{"type_name":"营养食品","order_key":"0/10/20/30","type_id":"100","type_sort":"51","class_id":"1062","type_img":"","class_name":"最新产品","type_index":2},{"type_name":"增强儿童智力免疫力食品","order_key":"0/10/20/30","type_id":"101","type_sort":"52","class_id":"1062","type_img":"","class_name":"最新产品","type_index":2},{"type_name":"母亲健康食品","order_key":"0/10/20/30","type_id":"102","type_sort":"53","class_id":"1062","type_img":"","class_name":"最新产品","type_index":2},{"type_name":"蛋白粉和补品","order_key":"0/10/20/30","type_id":"103","type_sort":"54","class_id":"1062","type_img":"","class_name":"最新产品","type_index":2},{"type_name":"专题文章","order_key":"0/10/20/30","type_id":"105","type_sort":"55","class_id":"1062","type_img":"","class_name":"最新产品","type_index":2},{"type_name":"世外香格专有产品","order_key":"0/10/20/30","type_id":"104","type_sort":"56","class_id":"1062","type_img":"","class_name":"最新产品","type_index":2}],"img_list":{"ap_id":"1048","adv_list":[{"ap_id":"1048","member_id":"0","adv_content":"a:2:{s:7:\"adv_pic\";s:21:\"05231208186909581.png\";s:11:\"adv_pic_url\";s:0:\"\";}","goldpay":"0","adv_end_date":"1790265600","click_num":"0","member_name":"","buy_style":"","adv_pic":"http://washop.turuitech.com/data/upload/shop/adv/05231208186909581.png","adv_pic_url":"","adv_id":"943","is_allow":"1","adv_start_date":"1467820800","slide_sort":"0","adv_title":"首页广告"}],"ap_class":"0","ap_display":"1","click_num":"0","ap_height":"260","ap_width":"640","ap_price":"0","ap_name":"世外香格","adv_num":"5","position":null,"is_use":"1","ap_intro":"","default_content":"http://washop.turuitech.com/data/upload/shop/adv/05066123490700004.png"}}
     */
    private int code;
    private DatasEntity datas;

    public void setCode(int code) {
        this.code = code;
    }

    public void setDatas(DatasEntity datas) {
        this.datas = datas;
    }

    public int getCode() {
        return code;
    }

    public DatasEntity getDatas() {
        return datas;
    }

    public class DatasEntity {
        /**
         * type_list : [{"type_name":"能量棒与零食榜","order_key":"0/10/20/30","type_id":"47","type_sort":"1","class_id":"1057","type_img":"","class_name":"运动健身","type_index":0},{"type_name":"蛋白粉和高蛋白能量棒","order_key":"0/10/20/30","type_id":"48","type_sort":"2","class_id":"1057","type_img":"","class_name":"运动健身","type_index":0},{"type_name":"超级食品","order_key":"0/10/20/30","type_id":"49","type_sort":"3","class_id":"1057","type_img":"","class_name":"运动健身","type_index":0},{"type_name":"营养饮品","order_key":"0/10/20/30","type_id":"50","type_sort":"4","class_id":"1057","type_img":"","class_name":"运动健身","type_index":0},{"type_name":"健康保健","order_key":"0/10/20/30","type_id":"51","type_sort":"5","class_id":"1057","type_img":"","class_name":"运动健身","type_index":1},{"type_name":"世外香格专有产品","order_key":"0/10/20/30","type_id":"52","type_sort":"6","class_id":"1057","type_img":"","class_name":"运动健身","type_index":2},{"type_name":"专题文章","order_key":"0/10/20/30","type_id":"53","type_sort":"7","class_id":"1057","type_img":"","class_name":"运动健身","type_index":2},{"type_name":"超级食品","order_key":"0/10/20/30","type_id":"56","type_sort":"8","class_id":"1059","type_img":"","class_name":"有机食品","type_index":2},{"type_name":"健康甜味剂、食油、香料、调味品和盐","order_key":"0/10/20/30","type_id":"57","type_sort":"9","class_id":"1059","type_img":"","class_name":"有机食品","type_index":2},{"type_name":"健康零食","order_key":"0/10/20/30","type_id":"58","type_sort":"10","class_id":"1059","type_img":"","class_name":"有机食品","type_index":2},{"type_name":"早餐食品、有机奶粉","order_key":"0/10/20/30","type_id":"59","type_sort":"11","class_id":"1059","type_img":"","class_name":"有机食品","type_index":2},{"type_name":"营养饮品","order_key":"0/10/20/30","type_id":"60","type_sort":"12","class_id":"1059","type_img":"","class_name":"有机食品","type_index":2},{"type_name":"蛋白粉和补品","order_key":"0/10/20/30","type_id":"62","type_sort":"13","class_id":"1059","type_img":"","class_name":"有机食品","type_index":2},{"type_name":"专题文章","order_key":"0/10/20/30","type_id":"64","type_sort":"14","class_id":"1059","type_img":"","class_name":"有机食品","type_index":2},{"type_name":"世外香格专有产品","order_key":"0/10/20/30","type_id":"63","type_sort":"15","class_id":"1059","type_img":"","class_name":"有机食品","type_index":2},{"type_name":"儿童食品和健康零食","order_key":"0/10/20/30","type_id":"65","type_sort":"16","class_id":"1058","type_img":"","class_name":"婴童保健","type_index":2},{"type_name":"儿童增强智力免疫力健康食品","order_key":"0/10/20/30","type_id":"66","type_sort":"17","class_id":"1058","type_img":"","class_name":"婴童保健","type_index":2},{"type_name":"婴儿沐浴和成人美容护理品","order_key":"0/10/20/30","type_id":"67","type_sort":"18","class_id":"1058","type_img":"","class_name":"婴童保健","type_index":2},{"type_name":"宝宝喂养","order_key":"0/10/20/30","type_id":"68","type_sort":"19","class_id":"1058","type_img":"","class_name":"婴童保健","type_index":2},{"type_name":"准妈妈营养","order_key":"0/10/20/30","type_id":"69","type_sort":"20","class_id":"1058","type_img":"","class_name":"婴童保健","type_index":2},{"type_name":"超级食品","order_key":"0/10/20/30","type_id":"70","type_sort":"21","class_id":"1058","type_img":"","class_name":"婴童保健","type_index":2},{"type_name":"专题文章","order_key":"0/10/20/30","type_id":"73","type_sort":"22","class_id":"1058","type_img":"","class_name":"婴童保健","type_index":2},{"type_name":"蛋白粉和补品","order_key":"0/10/20/30","type_id":"71","type_sort":"23","class_id":"1058","type_img":"","class_name":"婴童保健","type_index":2},{"type_name":"世外香格专有产品","order_key":"0/10/20/30","type_id":"72","type_sort":"24","class_id":"1058","type_img":"","class_name":"婴童保健","type_index":2},{"type_name":"儿童保健品","order_key":"0/10/20/30","type_id":"74","type_sort":"25","class_id":"1060","type_img":"","class_name":"维生素补","type_index":2},{"type_name":"抗癌补充剂及补品","order_key":"0/10/20/30","type_id":"75","type_sort":"26","class_id":"1060","type_img":"","class_name":"维生素补","type_index":2},{"type_name":"多种维生素","order_key":"0/10/20/30","type_id":"76","type_sort":"27","class_id":"1060","type_img":"","class_name":"维生素补","type_index":2},{"type_name":"女性健康保健品","order_key":"0/10/20/30","type_id":"77","type_sort":"28","class_id":"1060","type_img":"","class_name":"维生素补","type_index":2},{"type_name":"男性健康保健品","order_key":"0/10/20/30","type_id":"78","type_sort":"29","class_id":"1060","type_img":"","class_name":"维生素补","type_index":2},{"type_name":"超级食品","order_key":"0/10/20/30","type_id":"79","type_sort":"30","class_id":"1060","type_img":"","class_name":"维生素补","type_index":2},{"type_name":"专题文章","order_key":"0/10/20/30","type_id":"81","type_sort":"31","class_id":"1060","type_img":"","class_name":"维生素补","type_index":2},{"type_name":"世外香格专有产品","order_key":"0/10/20/30","type_id":"80","type_sort":"32","class_id":"1060","type_img":"","class_name":"维生素补","type_index":2},{"type_name":"抗癌补充剂及补品","order_key":"0/10/20/30","type_id":"82","type_sort":"33","class_id":"1102","type_img":"","class_name":"抗癌补品","type_index":2},{"type_name":"蛋白粉和能量补品","order_key":"0/10/20/30","type_id":"83","type_sort":"34","class_id":"1102","type_img":"","class_name":"抗癌补品","type_index":2},{"type_name":"多种维生素","order_key":"0/10/20/30","type_id":"84","type_sort":"35","class_id":"1102","type_img":"","class_name":"抗癌补品","type_index":2},{"type_name":"女性保健营养品","order_key":"0/10/20/30","type_id":"85","type_sort":"36","class_id":"1102","type_img":"","class_name":"抗癌补品","type_index":2},{"type_name":"男性保健营养品","order_key":"0/10/20/30","type_id":"86","type_sort":"37","class_id":"1102","type_img":"","class_name":"抗癌补品","type_index":2},{"type_name":"超级食品","order_key":"0/10/20/30","type_id":"87","type_sort":"38","class_id":"1102","type_img":"","class_name":"抗癌补品","type_index":2},{"type_name":"专题文章","order_key":"0/10/20/30","type_id":"89","type_sort":"39","class_id":"1102","type_img":"","class_name":"抗癌补品","type_index":2},{"type_name":"世外香格专有产品","order_key":"0/10/20/30","type_id":"88","type_sort":"40","class_id":"1102","type_img":"","class_name":"抗癌补品","type_index":2},{"type_name":"超级食品","order_key":"0/10/20/30","type_id":"90","type_sort":"41","class_id":"1061","type_img":"","class_name":"专家选择","type_index":2},{"type_name":"营养饮品","order_key":"0/10/20/30","type_id":"91","type_sort":"42","class_id":"1061","type_img":"","class_name":"专家选择","type_index":2},{"type_name":"能量棒与零食棒","order_key":"0/10/20/30","type_id":"92","type_sort":"43","class_id":"1061","type_img":"","class_name":"专家选择","type_index":2},{"type_name":"男性营养品","order_key":"0/10/20/30","type_id":"93","type_sort":"44","class_id":"1061","type_img":"","class_name":"专家选择","type_index":2},{"type_name":"女性营养品","order_key":"0/10/20/30","type_id":"94","type_sort":"45","class_id":"1061","type_img":"","class_name":"专家选择","type_index":2},{"type_name":"蛋白粉和补品","order_key":"0/10/20/30","type_id":"95","type_sort":"46","class_id":"1061","type_img":"","class_name":"专家选择","type_index":2},{"type_name":"专题文章","order_key":"0/10/20/30","type_id":"97","type_sort":"47","class_id":"1061","type_img":"","class_name":"专家选择","type_index":2},{"type_name":"世外香格专有产品","order_key":"0/10/20/30","type_id":"96","type_sort":"48","class_id":"1061","type_img":"","class_name":"专家选择","type_index":2},{"type_name":"抗癌补充剂及补品","order_key":"0/10/20/30","type_id":"98","type_sort":"49","class_id":"1062","type_img":"","class_name":"最新产品","type_index":2},{"type_name":"超级食品","order_key":"0/10/20/30","type_id":"99","type_sort":"50","class_id":"1062","type_img":"","class_name":"最新产品","type_index":2},{"type_name":"营养食品","order_key":"0/10/20/30","type_id":"100","type_sort":"51","class_id":"1062","type_img":"","class_name":"最新产品","type_index":2},{"type_name":"增强儿童智力免疫力食品","order_key":"0/10/20/30","type_id":"101","type_sort":"52","class_id":"1062","type_img":"","class_name":"最新产品","type_index":2},{"type_name":"母亲健康食品","order_key":"0/10/20/30","type_id":"102","type_sort":"53","class_id":"1062","type_img":"","class_name":"最新产品","type_index":2},{"type_name":"蛋白粉和补品","order_key":"0/10/20/30","type_id":"103","type_sort":"54","class_id":"1062","type_img":"","class_name":"最新产品","type_index":2},{"type_name":"专题文章","order_key":"0/10/20/30","type_id":"105","type_sort":"55","class_id":"1062","type_img":"","class_name":"最新产品","type_index":2},{"type_name":"世外香格专有产品","order_key":"0/10/20/30","type_id":"104","type_sort":"56","class_id":"1062","type_img":"","class_name":"最新产品","type_index":2}]
         * img_list : {"ap_id":"1048","adv_list":[{"ap_id":"1048","member_id":"0","adv_content":"a:2:{s:7:\"adv_pic\";s:21:\"05231208186909581.png\";s:11:\"adv_pic_url\";s:0:\"\";}","goldpay":"0","adv_end_date":"1790265600","click_num":"0","member_name":"","buy_style":"","adv_pic":"http://washop.turuitech.com/data/upload/shop/adv/05231208186909581.png","adv_pic_url":"","adv_id":"943","is_allow":"1","adv_start_date":"1467820800","slide_sort":"0","adv_title":"首页广告"}],"ap_class":"0","ap_display":"1","click_num":"0","ap_height":"260","ap_width":"640","ap_price":"0","ap_name":"世外香格","adv_num":"5","position":null,"is_use":"1","ap_intro":"","default_content":"http://washop.turuitech.com/data/upload/shop/adv/05066123490700004.png"}
         */
        private List<Type_listEntity> type_list;
        private Img_listEntity img_list;

        public void setType_list(List<Type_listEntity> type_list) {
            this.type_list = type_list;
        }

        public void setImg_list(Img_listEntity img_list) {
            this.img_list = img_list;
        }

        public List<Type_listEntity> getType_list() {
            return type_list;
        }

        public Img_listEntity getImg_list() {
            return img_list;
        }

        public class Type_listEntity {
            /**
             * type_name : 能量棒与零食榜
             * order_key : 0/10/20/30
             * type_id : 47
             * type_sort : 1
             * class_id : 1057
             * type_img :
             * class_name : 运动健身
             * type_index : 0
             */
            private String type_name;
            private String order_key;
            private String type_id;
            private String type_sort;
            private String class_id;
            private String type_img;
            private String class_name;
            private int type_index;

            public void setType_name(String type_name) {
                this.type_name = type_name;
            }

            public void setOrder_key(String order_key) {
                this.order_key = order_key;
            }

            public void setType_id(String type_id) {
                this.type_id = type_id;
            }

            public void setType_sort(String type_sort) {
                this.type_sort = type_sort;
            }

            public void setClass_id(String class_id) {
                this.class_id = class_id;
            }

            public void setType_img(String type_img) {
                this.type_img = type_img;
            }

            public void setClass_name(String class_name) {
                this.class_name = class_name;
            }

            public void setType_index(int type_index) {
                this.type_index = type_index;
            }

            public String getType_name() {
                return type_name;
            }

            public String getOrder_key() {
                return order_key;
            }

            public String getType_id() {
                return type_id;
            }

            public String getType_sort() {
                return type_sort;
            }

            public String getClass_id() {
                return class_id;
            }

            public String getType_img() {
                return type_img;
            }

            public String getClass_name() {
                return class_name;
            }

            public int getType_index() {
                return type_index;
            }
        }

        public class Img_listEntity {
            /**
             * ap_id : 1048
             * adv_list : [{"ap_id":"1048","member_id":"0","adv_content":"a:2:{s:7:\"adv_pic\";s:21:\"05231208186909581.png\";s:11:\"adv_pic_url\";s:0:\"\";}","goldpay":"0","adv_end_date":"1790265600","click_num":"0","member_name":"","buy_style":"","adv_pic":"http://washop.turuitech.com/data/upload/shop/adv/05231208186909581.png","adv_pic_url":"","adv_id":"943","is_allow":"1","adv_start_date":"1467820800","slide_sort":"0","adv_title":"首页广告"}]
             * ap_class : 0
             * ap_display : 1
             * click_num : 0
             * ap_height : 260
             * ap_width : 640
             * ap_price : 0
             * ap_name : 世外香格
             * adv_num : 5
             * position : null
             * is_use : 1
             * ap_intro :
             * default_content : http://washop.turuitech.com/data/upload/shop/adv/05066123490700004.png
             */
            private String ap_id;
            private List<Adv_listEntity> adv_list;
            private String ap_class;
            private String ap_display;
            private String click_num;
            private String ap_height;
            private String ap_width;
            private String ap_price;
            private String ap_name;
            private String adv_num;
            private String position;
            private String is_use;
            private String ap_intro;
            private String default_content;

            public void setAp_id(String ap_id) {
                this.ap_id = ap_id;
            }

            public void setAdv_list(List<Adv_listEntity> adv_list) {
                this.adv_list = adv_list;
            }

            public void setAp_class(String ap_class) {
                this.ap_class = ap_class;
            }

            public void setAp_display(String ap_display) {
                this.ap_display = ap_display;
            }

            public void setClick_num(String click_num) {
                this.click_num = click_num;
            }

            public void setAp_height(String ap_height) {
                this.ap_height = ap_height;
            }

            public void setAp_width(String ap_width) {
                this.ap_width = ap_width;
            }

            public void setAp_price(String ap_price) {
                this.ap_price = ap_price;
            }

            public void setAp_name(String ap_name) {
                this.ap_name = ap_name;
            }

            public void setAdv_num(String adv_num) {
                this.adv_num = adv_num;
            }

            public void setPosition(String position) {
                this.position = position;
            }

            public void setIs_use(String is_use) {
                this.is_use = is_use;
            }

            public void setAp_intro(String ap_intro) {
                this.ap_intro = ap_intro;
            }

            public void setDefault_content(String default_content) {
                this.default_content = default_content;
            }

            public String getAp_id() {
                return ap_id;
            }

            public List<Adv_listEntity> getAdv_list() {
                return adv_list;
            }

            public String getAp_class() {
                return ap_class;
            }

            public String getAp_display() {
                return ap_display;
            }

            public String getClick_num() {
                return click_num;
            }

            public String getAp_height() {
                return ap_height;
            }

            public String getAp_width() {
                return ap_width;
            }

            public String getAp_price() {
                return ap_price;
            }

            public String getAp_name() {
                return ap_name;
            }

            public String getAdv_num() {
                return adv_num;
            }

            public String getPosition() {
                return position;
            }

            public String getIs_use() {
                return is_use;
            }

            public String getAp_intro() {
                return ap_intro;
            }

            public String getDefault_content() {
                return default_content;
            }

            public class Adv_listEntity {
                /**
                 * ap_id : 1048
                 * member_id : 0
                 * adv_content : a:2:{s:7:"adv_pic";s:21:"05231208186909581.png";s:11:"adv_pic_url";s:0:"";}
                 * goldpay : 0
                 * adv_end_date : 1790265600
                 * click_num : 0
                 * member_name :
                 * buy_style :
                 * adv_pic : http://washop.turuitech.com/data/upload/shop/adv/05231208186909581.png
                 * adv_pic_url :
                 * adv_id : 943
                 * is_allow : 1
                 * adv_start_date : 1467820800
                 * slide_sort : 0
                 * adv_title : 首页广告
                 */
                private String ap_id;
                private String member_id;
                private String adv_content;
                private String goldpay;
                private String adv_end_date;
                private String click_num;
                private String member_name;
                private String buy_style;
                private String adv_pic;
                private String adv_pic_url;
                private String adv_id;
                private String is_allow;
                private String adv_start_date;
                private String slide_sort;
                private String adv_title;

                public void setAp_id(String ap_id) {
                    this.ap_id = ap_id;
                }

                public void setMember_id(String member_id) {
                    this.member_id = member_id;
                }

                public void setAdv_content(String adv_content) {
                    this.adv_content = adv_content;
                }

                public void setGoldpay(String goldpay) {
                    this.goldpay = goldpay;
                }

                public void setAdv_end_date(String adv_end_date) {
                    this.adv_end_date = adv_end_date;
                }

                public void setClick_num(String click_num) {
                    this.click_num = click_num;
                }

                public void setMember_name(String member_name) {
                    this.member_name = member_name;
                }

                public void setBuy_style(String buy_style) {
                    this.buy_style = buy_style;
                }

                public void setAdv_pic(String adv_pic) {
                    this.adv_pic = adv_pic;
                }

                public void setAdv_pic_url(String adv_pic_url) {
                    this.adv_pic_url = adv_pic_url;
                }

                public void setAdv_id(String adv_id) {
                    this.adv_id = adv_id;
                }

                public void setIs_allow(String is_allow) {
                    this.is_allow = is_allow;
                }

                public void setAdv_start_date(String adv_start_date) {
                    this.adv_start_date = adv_start_date;
                }

                public void setSlide_sort(String slide_sort) {
                    this.slide_sort = slide_sort;
                }

                public void setAdv_title(String adv_title) {
                    this.adv_title = adv_title;
                }

                public String getAp_id() {
                    return ap_id;
                }

                public String getMember_id() {
                    return member_id;
                }

                public String getAdv_content() {
                    return adv_content;
                }

                public String getGoldpay() {
                    return goldpay;
                }

                public String getAdv_end_date() {
                    return adv_end_date;
                }

                public String getClick_num() {
                    return click_num;
                }

                public String getMember_name() {
                    return member_name;
                }

                public String getBuy_style() {
                    return buy_style;
                }

                public String getAdv_pic() {
                    return adv_pic;
                }

                public String getAdv_pic_url() {
                    return adv_pic_url;
                }

                public String getAdv_id() {
                    return adv_id;
                }

                public String getIs_allow() {
                    return is_allow;
                }

                public String getAdv_start_date() {
                    return adv_start_date;
                }

                public String getSlide_sort() {
                    return slide_sort;
                }

                public String getAdv_title() {
                    return adv_title;
                }
            }
        }
    }
}
