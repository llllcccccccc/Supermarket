<template>
    <div class="login-altair login_page">
        <div class="login_page_wrapper">
            <div class="md-card" id="login_card">
                <div class="md-card-content large-padding" id="login_form">
                    <div class="login_heading" style="font-size: 16px">{{ setting.title }}</div>
                    <form action="javascript:;" method="post" @submit="login">
                        <div class="uk-form-row">
                            <md-input v-model="form.username" title="用户名"/>
                        </div>
                        <div class="uk-form-row">
                            <md-input v-model="form.pwd" type="password" title="密码"/>
                        </div>
                        
                        <div class="uk-margin-medium-top">
                            <button type="submit" class="md-btn md-btn-primary md-btn-block md-btn-large">登录</button>
                        </div>
                    </form>
                </div>
            </div>
        </div>
    </div>
</template>
<style type="text/scss" lang="scss">
    .login-altair {
        height: 100vh;
        width: 100%;
        padding: 64px 24px;
        background: url("./images/altair-login-bg.jpg");
        background-size: cover;

        .login_page_wrapper {
            width: 360px;
            margin: 0 auto;
            transform: translateY(20%);
            max-width: 100%;
            transition: all 280ms cubic-bezier(0.4, 0, 0.2, 1);
        }

        .md-card {
            background: rgba(255, 255, 255, 0.8);
            position: relative;
            box-shadow: 0 1px 10px rgba(0, 0, 0, 0.5), 0 1px 10px rgba(0, 0, 0, 0.3);
            border: none;

            .md-card-content.large-padding {
                padding: 24px 35px;
            }
        }

        .uk-form-row {
            transition: all 0.2s ease-out;
            margin-bottom: 20px;
        }

        .uk-form-row:after,
        .uk-form-row:before {
            content: "";
            display: table;
        }

        .uk-form-row:after {
            clear: both;
        }

        .uk-form-row:after,
        .uk-form-row:before {
            content: "";
            display: table;
        }

        .md-input-wrapper {
            position: relative;
            padding-top: 4px;
            width: 100%;
            display: block;

            > label {
                color: #727272;
                position: absolute;
                top: 16px;
                left: 4px;
                right: 0;
                pointer-events: none;
                -webkit-transition: all 150ms ease-out;
                transition: all 150ms ease-out;
            }

            .md-input-bar {
                display: block;
                position: absolute;
                bottom: 0;
                left: 0;
                width: 100%;
            }

            .md-input-bar:before {
                left: 50%;
            }

            .md-input-bar:after {
                right: 50%;
            }

            .md-input-bar:after,
            .md-input-bar:before {
                content: "";
                display: block;
                position: absolute;
                bottom: 0;
                width: 0;
                height: 2px;
                background: #1976d2;
                -webkit-transition: width 0.4s cubic-bezier(0.4, 0, 0.2, 1);
                transition: width 0.4s cubic-bezier(0.4, 0, 0.2, 1);
            }

            &.md-input-focus > label {
                top: -12px;
                font-size: 12px;
            }

            &.md-input-focus .md-input-bar:after,
            &.md-input-focus .md-input-bar:before {
                width: 50%;
            }
        }

        input:not([type]).md-input,
        input[type="text"].md-input,
        input[type="password"].md-input,
        input[type="datetime"].md-input,
        input[type="datetime-local"].md-input,
        input[type="date"].md-input,
        input[type="month"].md-input,
        input[type="time"].md-input,
        input[type="week"].md-input,
        input[type="number"].md-input,
        input[type="email"].md-input,
        input[type="url"].md-input,
        input[type="search"].md-input,
        input[type="tel"].md-input,
        input[type="color"].md-input,
        select.md-input,
        textarea.md-input {
            border-radius: 0;
            border-width: 0 0 1px;
            border-style: solid;
            border-color: rgba(0, 0, 0, 0.12);
            font: 400 15px/18px Roboto, sans-serif;
            box-shadow: inset 0 -1px 0 transparent;
            box-sizing: border-box;
            padding: 12px 4px;
            background: 0 0;
            width: 100%;
            display: block;
        }

        input:not([type]),
        input[type="text"],
        input[type="password"],
        input[type="datetime"],
        input[type="datetime-local"],
        input[type="date"],
        input[type="month"],
        input[type="time"],
        input[type="week"],
        input[type="number"],
        input[type="email"],
        input[type="url"],
        input[type="search"],
        input[type="tel"],
        input[type="color"],
        select,
        textarea {
            outline: 0;
        }

        .login_heading {
            text-align: center;
            margin-bottom: 32px;
        }

        .md-btn {
            background: #fff;
            border: none;
            border-radius: 2px;
            box-shadow: 0 1px 3px rgba(0, 0, 0, 0.12), 0 1px 2px rgba(0, 0, 0, 0.24);
            min-height: 31px;
            min-width: 70px;
            padding: 2px 16px;
            text-align: center;
            text-shadow: none;
            text-transform: uppercase;
            -webkit-transition: all 280ms cubic-bezier(0.4, 0, 0.2, 1);
            transition: all 280ms cubic-bezier(0.4, 0, 0.2, 1);
            color: #212121;
            box-sizing: border-box;
            cursor: pointer;
            -webkit-appearance: none;
            display: inline-block;
            vertical-align: middle;
            font: 500 14px/31px Roboto, sans-serif !important;
        }

        .md-btn-block {
            width: 100%;
        }

        .md-btn-large {
            line-height: 42px;
            font-size: 16px;
        }

        .md-btn-primary,
        .md-btn-primary:active,
        .md-btn-primary:focus,
        .md-btn-primary:hover {
            background: #2196f3;
            color: #fff;
        }
    }
</style>
<script>
    import setting from "@/setting";
    import api from "@/api";
    import MdInput from "@/views/login/input";

    export default {
        name: "login-index",
        components: {MdInput},
        data() {
            return {
                setting,
                loading: false,
                errorNotification: "",
                form: {
                    username: "",
                    pwd: "",
                    cx: "",
                },
                rules: ["管理员"],
            };
        },
        watch: {},
        computed: {},
        methods: {
            validateLogin() {
                var form = this.form;
                var username = form.username;
                var pwd = form.pwd;

                if (username == "") {
                    this.errorNotification = "帐号不能为空";
                    return false;
                }
                if (pwd == "") {
                    this.errorNotification = "密码不能为空";
                    return false;
                }
                this.errorNotification = "";
                return true;
            },
            loadCaptch() {
                api.captch().then((res) => {
                    this.captchUrl = res;
                });
            },
            login() {
                if (this.validateLogin()) {
                    this.loading = true;
                    this.$store
                        .dispatch("user/login", this.form)
                        .then((res) => {
                            this.loading = false;
                            if (res.code == api.code.OK) {
                                this.$message.success("登录成功");
                                var redirect = this.$route.query.redirect;
                                if (redirect) {
                                    this.$router.replace(redirect);
                                } else {
                                    this.$router.replace("/admin/sy");
                                }
                            } else {
                                this.$message.error(res.msg);
                            }
                        })
                        .catch((err) => {
                            this.loading = false;
                            this.$message.error(err.message);
                        });
                }
            },
        },
        created() {
            this.form.cx = this.rules[0];
            this.loadCaptch();
        },
        mounted() {
        },
        destroyed() {
        },
    };
</script>
