<template>
    <div class="gongyingshang-add" v-loading="loading">
        <el-card class="box-card">
            <div slot="header" class="clearfix">
                <span class="title"> 添加供应商</span>
            </div>
            <div class="form-database-form">
                <el-form :model="form" ref="formModel" label-width="130px" status-icon validate-on-rule-change>
                    <el-form-item label="供应商编号" prop="gongyingshangbianhao" :rules="[{required:true, message:'请填写供应商编号'}]">
                        <el-input type="text" placeholder="输入供应商编号" style="width: 250px" v-model="form.gongyingshangbianhao" />
                    </el-form-item>

                    <el-form-item
                        label="供应商名称"
                        prop="gongyingshangmingcheng"
                        required
                        :rules="[{required:true, message:'请填写供应商名称'}, {validator:rule.checkRemote, message:'内容重复了', checktype:'insert', module:'gongyingshang', col:'gongyingshangmingcheng', trigger:'blur'}]"
                    >
                        <el-input type="text" placeholder="输入供应商名称" style="width: 450px" v-model="form.gongyingshangmingcheng" />
                    </el-form-item>

                    <el-form-item
                        label="供应商电话"
                        prop="gongyingshangdianhua"
                        required
                        :rules="[{required:true, message:'请填写供应商电话'}, {validator:rule.checkPhone, message:'请输入正确手机号码'}]"
                    >
                        <el-input type="text" placeholder="输入供应商电话" style="width: 250px" v-model="form.gongyingshangdianhua" />
                    </el-form-item>

                    <el-form-item label="供应商地址" prop="gongyingshangdizhi" required :rules="[{required:true, message:'请填写供应商地址'}]">
                        <el-input type="text" placeholder="输入供应商地址" style="width: 450px" v-model="form.gongyingshangdizhi" />
                    </el-form-item>

                    <el-form-item label="供应商详情" prop="gongyingshangxiangqing"> <el-input type="textarea" v-model="form.gongyingshangxiangqing"></el-input> </el-form-item>

                    <el-form-item v-if="btnText">
                        <el-button type="primary" @click="submit">{{ btnText }}</el-button>
                    </el-form-item>
                </el-form>
            </div>
        </el-card>
    </div>
</template>
<style type="text/scss" scoped lang="scss">
    .gongyingshang-add {
    }
</style>
<script>
    import api from "@/api";
    import rule from "@/utils/rule";
    import { extend } from "@/utils/extend";

    export default {
        name: "gongyingshang-add",
        data() {
            return {
                rule,
                loading: false,
                form: {
                    gongyingshangbianhao: rule.getID(),
                    gongyingshangmingcheng: "",
                    gongyingshangdianhua: "",
                    gongyingshangdizhi: "",
                    gongyingshangxiangqing: "",
                },
            };
        },
        watch: {},
        props: {
            isRead: {
                type: Boolean,
                default: true,
            },
            btnText: {
                type: String,
                default: "提交",
            },
        },

        computed: {},
        methods: {
            submit() {
                this.$refs.formModel
                    .validate()
                    .then((res) => {
                        if (this.loading) return;
                        this.loading = true;
                        var form = this.form;

                        this.$post(api.gongyingshang.insert, form)
                            .then((res) => {
                                this.loading = false;
                                if (res.code == api.code.OK) {
                                    this.$message.success("添加成功");
                                    this.$emit("success", res.data);
                                    this.$refs.formModel.resetFields();
                                    this.loadInfo();
                                } else {
                                    this.$message.error(res.msg);
                                }
                            })
                            .catch((err) => {
                                this.loading = false;
                                this.$message.error(err.message);
                            });
                    })
                    .catch((err) => {
                        console.log(err.message);
                    });
            },
            loadInfo() {
                var form = this.form;
                // 获取模块得数据
                this.loading = true;
                this.$post(api.gongyingshang.create, {
                    id: this.$route.query.id,
                })
                    .then((res) => {
                        this.loading = false;
                        if (res.code == api.code.OK) {
                            extend(this, res.data);
                        } else {
                            this.$message.error(res.msg);
                            this.$router.go(-1);
                        }
                    })
                    .catch((err) => {
                        this.$message.error(err.message);
                        this.$router.go(-1);
                    });
            },
        },
        created() {
            this.loadInfo();
        },
        mounted() {},
        destroyed() {},
    };
</script>
