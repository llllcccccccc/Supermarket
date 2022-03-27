<template>
    <div class="jinhuo-add" v-loading="loading">
        <el-card class="box-card">
            <div slot="header" class="clearfix">
                <span class="title"> 添加进货</span>
            </div>
            <div class="form-database-form">
                <el-form :model="form" ref="formModel" label-width="130px" status-icon validate-on-rule-change>
                    <el-form-item v-if="isRead" label="商品编号" prop="shangpinbianhao"> {{ form.shangpinbianhao }} </el-form-item>

                    <el-form-item v-if="isRead" label="商品名称" prop="shangpinmingcheng"> {{ form.shangpinmingcheng }} </el-form-item>

                    <el-form-item v-if="isRead" label="分类" prop="fenlei">
                        <e-select-view module="shangpinfenlei" :value="form.fenlei" select="id" show="fenlei"></e-select-view>
                    </el-form-item>

                    <el-form-item label="供应商" prop="gongyingshang">
                        <e-select-list
                            :model="form"
                            v-model="form.gongyingshang"
                            module="gongyingshang"
                            select-update="gongyingshangbianhao,gongyingshangmingcheng,gongyingshangdianhua"
                            search-update=""
                        ></e-select-list>
                        <table>
                            <tr>
                                <td width="120">供应商编号</td>
                                <td>{{ form.gongyingshangbianhao }}</td>
                            </tr>
                            <tr>
                                <td width="120">供应商名称</td>
                                <td>{{ form.gongyingshangmingcheng }}</td>
                            </tr>
                            <tr>
                                <td width="120">供应商电话</td>
                                <td>{{ form.gongyingshangdianhua }}</td>
                            </tr>
                        </table>
                    </el-form-item>

                    <el-form-item label="供应商编号" prop="gongyingshangbianhao">
                        <el-input type="text" placeholder="输入供应商编号" style="width: 250px" v-model="form.gongyingshangbianhao" />
                    </el-form-item>

                    <el-form-item label="供应商名称" prop="gongyingshangmingcheng">
                        <el-input type="text" placeholder="输入供应商名称" style="width: 450px" v-model="form.gongyingshangmingcheng" />
                    </el-form-item>

                    <el-form-item label="供应商电话" prop="gongyingshangdianhua">
                        <el-input type="text" placeholder="输入供应商电话" style="width: 250px" v-model="form.gongyingshangdianhua" />
                    </el-form-item>

                    <el-form-item v-if="isRead" label="进货价格" prop="jinhuojiage" :rules="[{validator:rule.checkNumber, message:'输入一个有效数字'}]">
                        {{ form.jinhuojiage }}
                    </el-form-item>

                    <el-form-item
                        label="进货数量"
                        prop="jinhuoshuliang"
                        required
                        :rules="[{required:true, message:'请填写进货数量'}, {validator:rule.checkNumber, message:'输入一个有效数字'}]"
                    >
                        <el-input type="number" placeholder="输入进货数量" style="width: 250px" v-model.number="form.jinhuoshuliang" />
                    </el-form-item>

                    <el-form-item label="进货备注" prop="jinhuobeizhu"> <el-input type="textarea" v-model="form.jinhuobeizhu"></el-input> </el-form-item>

                    <el-form-item label="操作人" prop="caozuoren"> <el-input v-model="form.caozuoren" readonly style="width: 250px"></el-input> </el-form-item>

                    <el-form-item v-if="btnText">
                        <el-button type="primary" @click="submit">{{ btnText }}</el-button>
                    </el-form-item>
                </el-form>
            </div>
        </el-card>
    </div>
</template>
<style type="text/scss" scoped lang="scss">
    .jinhuo-add {
    }
</style>
<script>
    import api from "@/api";
    import rule from "@/utils/rule";
    import { extend } from "@/utils/extend";

    export default {
        name: "jinhuo-add",
        data() {
            return {
                readMap: {},
                rule,
                loading: false,
                form: {
                    shangpinbianhao: "",
                    shangpinmingcheng: "",
                    fenlei: "",
                    gongyingshang: "",
                    gongyingshangbianhao: "",
                    gongyingshangmingcheng: "",
                    gongyingshangdianhua: "",
                    jinhuojiage: "",
                    jinhuoshuliang: "",
                    jinhuobeizhu: "",
                    caozuoren: this.$store.state.user.session.username,
                    shangpinxinxiid: 0,
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

                        this.$post(api.jinhuo.insert, form)
                            .then((res) => {
                                this.loading = false;
                                if (res.code == api.code.OK) {
                                    this.$message.success("添加成功");
                                    this.$emit("success", res.data);
                                    this.$refs.formModel.resetFields();
                                    this.$router.go(-1);
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
                this.$post(api.jinhuo.create, {
                    id: this.$route.query.id,
                })
                    .then((res) => {
                        this.loading = false;
                        if (res.code == api.code.OK) {
                            extend(this, res.data);
                            var readMap = res.data.readMap;
                            for (var i in form) {
                                if (readMap[i] && i != "id") {
                                    form[i] = res.data.readMap[i];
                                }
                            }
                            form.shangpinxinxiid = readMap.id;
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
