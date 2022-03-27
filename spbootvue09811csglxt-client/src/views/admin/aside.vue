<template>
    <div class="altair-aside">
        <el-scrollbar class="sidebar-list">
            <div style="width: 240px">
                <div class="sidebar_main_header">
                    <div class="sidebar_logo">
                        <router-link to="/index" class="sSidebar_hide"><img src="./images/logo_main_small.png" alt="" height="32" width="32" /></router-link>
                    </div>
                </div>

                <div class="menu_section">
                    <ul>
                        <li class="submenu_tigger" :class="{act_section:active==k}" v-for="(m,k) in menus">
                            <a href="javascript:;" @click="selectSection(k)">
                                <span class="menu_icon"><i class="material-icons" :class="m.icon?m.icon:'el-icon-s-unfold'"></i></span>
                                <span class="menu_title">{{m.label}}</span>
                                <i class="open el-icon-arrow-down"></i>
                            </a>
                            <ul class="sub-menu">
                                <li v-for="c in m.children"><router-link :to="c.to">{{ c.label }}</router-link></li>
                            </ul>
                        </li>
                    </ul>
                </div>
            </div>
        </el-scrollbar>
    </div>
</template>
<style type="text/scss" lang="scss">
    .altair-aside {
        overflow: hidden;
        .sidebar_main_header {
            height: 89px;
            border-bottom: 1px solid rgba(0, 0, 0, 0.12);
            margin-bottom: 20px;
            background-image: url(./images/sidebar_head_bg.png);
            background-repeat: no-repeat;
            background-position: -20px -124px;
            .sidebar_logo {
                height: 48px;
                line-height: 48px;
                overflow: hidden;
                padding-top: 20px;
                a {
                    display: inline-block;
                    margin-left: 20px;
                }
            }
        }

        .menu_section ul {
            margin: 0;
            > li {
                list-style: none;
                padding: 0;
                > a {
                    color: #212121;
                    padding: 8px 20px;
                    display: block;
                    overflow: hidden;
                    position: relative;
                    > .menu_icon {
                        width: 48px;
                        text-align: left;
                        display: inline-block;
                        color: #727272;
                        transition: transform 0.2s linear;
                        .material-icons {
                            font-size: 24px;
                            vertical-align: top;
                        }
                    }
                    > .open {
                        position: absolute;
                        right: 28px;
                        top: 9px;
                        font-size: 18px;
                        display: block;
                        color: #727272;
                        -webkit-transition: -webkit-transform 280ms;
                        transition: transform 280ms;
                    }
                }
                .sub-menu {
                    max-height: 0px;
                    overflow: hidden;
                    transition: max-height 280ms linear;
                    a {
                        padding: 8px 10px 8px 60px;
                        display: block;
                        color: #212121;
                    }
                }
                &.act_section {
                    > a > .open {
                        transform: rotate(180deg);
                    }
                    .sub-menu {
                        max-height: 300px;
                    }
                }
            }
        }

        .sidebar-list {
            height: 100%;
            overflow: hidden;
            .el-scrollbar {
                height: 100%;
            }
            .el-scrollbar__bar {
                &.is-vertical {
                    width: 4px; //滚动条宽度
                }
            }
            .el-scrollbar__wrap {
                overflow-y: auto;
                overflow-x: hidden;
            }
        }
    }
</style>
<script>
    import menu from "@/views/admin/sidebar";
    export default {
        name: "altair-aside",
        data() {
            return {
                active: 0,
            };
        },
        watch: {},
        computed: {
            menus() {
                var cx = this.$session.cx;
                return menu[cx];
            },
        },
        methods: {
            selectSection(k) {
                if (this.active == k) {
                    this.active = -1;
                } else {
                    this.active = k;
                }
            },
        },
        created() {},
        mounted() {},
        destroyed() {},
    };
</script>
