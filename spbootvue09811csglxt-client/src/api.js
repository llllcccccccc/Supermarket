import http from "@/utils/ajax/http";
import { extend } from "@/utils/extend";

const api = {
    code: {
        OK: 0,
    },
    user: {
        login: "authLogin.do?ac=login",
        tokenLogin: "tokenLogin.do",
        logout: "logout.do",
    },
    checkUpdate: "sh.do",
    editorPassword: "editPassword",
    checkField: "checkno.do",
    dbQuery: "/db/query",
    dbSelect: "/db/select",

    captch() {
        var url = "captcha.do?rd=" + Math.floor(Math.random() * 100000);
        return new Promise((resolve, reject) => {
            http.get(url).then((res) => {
                var url = res.data;
                resolve(url);
            }, reject);
        });
    },
    search: {
        select: "selectUpdateSearch.do",
        table: "tableAjax.do?a=table",
        selectView: "selectView.do",
        all: "selectAll.do",
    },
    attachment: {
        uploadUrl: "upload_re.do",
        upload(file) {
            return new Promise((resolve, reject) => {
                var formdata = new FormData();
                formdata.append("fujian", file, file.name || "tmp.png");
                http.post(api.attachment.uploadUrl, formdata)
                    .then((res) => {
                        if (res.code == api.code.OK) {
                            resolve(res.data);
                        } else {
                            reject(res.msg);
                        }
                    })
                    .catch((err) => {
                        reject(err.message);
                    });
            });
        },
    },
    admins: {
        list: "admins_list.do",
        insert: "adminsinsert.do",
        update: "adminsupdate.do",
        delete: "admins_delete.do",
        detail: "admins_detail.do",
        create: "admins_add.do",
        edit: "admins_updt.do",
    },
    gongyingshang: {
        list: "gongyingshang_list.do",
        insert: "gongyingshanginsert.do",
        update: "gongyingshangupdate.do",
        delete: "gongyingshang_delete.do",
        detail: "gongyingshang_detail.do",
        create: "gongyingshang_add.do",
        edit: "gongyingshang_updt.do",
    },
    shangpinfenlei: {
        list: "shangpinfenlei_list.do",
        insert: "shangpinfenleiinsert.do",
        update: "shangpinfenleiupdate.do",
        delete: "shangpinfenlei_delete.do",
        detail: "shangpinfenlei_detail.do",
        create: "shangpinfenlei_add.do",
        edit: "shangpinfenlei_updt.do",
    },
    shangpinxinxi: {
        list: "shangpinxinxi_list.do",
        insert: "shangpinxinxiinsert.do",
        update: "shangpinxinxiupdate.do",
        delete: "shangpinxinxi_delete.do",
        detail: "shangpinxinxi_detail.do",
        create: "shangpinxinxi_add.do",
        edit: "shangpinxinxi_updt.do",
    },
    jinhuo: {
        list: "jinhuo_list.do",
        insert: "jinhuoinsert.do",
        update: "jinhuoupdate.do",
        delete: "jinhuo_delete.do",
        detail: "jinhuo_detail.do",
        create: "jinhuo_add.do",
        edit: "jinhuo_updt.do",
        listcaozuoren: "jinhuo_list_caozuoren.do",
    },
    xiaoshou: {
        list: "xiaoshou_list.do",
        insert: "xiaoshouinsert.do",
        update: "xiaoshouupdate.do",
        delete: "xiaoshou_delete.do",
        detail: "xiaoshou_detail.do",
        create: "xiaoshou_add.do",
        edit: "xiaoshou_updt.do",
        listcaozuoren: "xiaoshou_list_caozuoren.do",
    },
};

export default api;
