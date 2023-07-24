// 停车场相关接口

const userUrl = baseURL + "user/";

console.info(baseURL)

/**
 *
 * @type {string}
 */
const getListUrl = userUrl + "getList";


/**
 * 保存
 * @type {string}
 */
const saveUrl = userUrl + "save";

/**
 * 删除
 * @type {string}
 */
const deleteUrl = userUrl + "delete/";

/**
 * 更新
 * @type {string}
 */
const updateUrl = userUrl + "put";
