// 停车场相关接口

const cardUrl = baseURL + "card/";

console.info(cardUrl)

/**
 *
 * @type {string}
 */
const getListUrl = cardUrl + "getList";


/**
 * 保存
 * @type {string}
 */
const saveUrl = cardUrl + "save";

/**
 * 删除
 * @type {string}
 */
const deleteUrl = cardUrl + "delete/";

/**
 * 更新
 * @type {string}
 */
const updateUrl = cardUrl + "put";
