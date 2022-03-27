export default [
    {
        label: "账号管理",
        to: "",
        children: [
            {
                label: "管理员账号管理",
                to: "/admin/admins",
            },
            {
                label: "管理员账号添加",
                to: "/admin/adminsadd",
            },
            {
                label: "密码修改",
                to: "/admin/mod",
            },
        ],
    },
    {
        label: "供应商管理",
        to: "",
        children: [
            {
                label: "供应商添加",
                to: "/admin/gongyingshangadd",
            },
            {
                label: "供应商查询",
                to: "/admin/gongyingshang",
            },
        ],
    },
    {
        label: "商品分类管理",
        to: "",
        children: [
            {
                label: "商品分类添加",
                to: "/admin/shangpinfenleiadd",
            },
            {
                label: "商品分类查询",
                to: "/admin/shangpinfenlei",
            },
        ],
    },
    {
        label: "商品信息管理",
        to: "",
        children: [
            {
                label: "商品信息添加",
                to: "/admin/shangpinxinxiadd",
            },
            {
                label: "商品信息查询",
                to: "/admin/shangpinxinxi",
            },
        ],
    },
    {
        label: "进货管理",
        to: "",
        children: [
            {
                label: "进货查询",
                to: "/admin/jinhuo",
            },
        ],
    },
    {
        label: "销售管理",
        to: "",
        children: [
            {
                label: "销售查询",
                to: "/admin/xiaoshou",
            },
        ],
    },

    {
        label: "统计管理",
        to: "",
        children: [
            {
                label: "进货统计",
                to: "/admin/total?src=total_jinhuo.jsp",
            },
            {
                label: "销售统计",
                to: "/admin/total?src=total_xiaoshou.jsp",
            },
        ],
    },
];
